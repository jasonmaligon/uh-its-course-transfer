"use strict"

var creditxferApp = angular.module("creditxferApp", ["ui.bootstrap", "ui.select", "ngSanitize", "ngAnimate"]);


function CreditxferJsController($scope, dataProvider) {
  var institutionUrl = "api/institutions";
  $scope.institutions = [];
  $scope.sources = [];
  $scope.targets = [];
  $scope.subjects = [];
  $scope.available = [];
  $scope.courses = [];
  $scope.attributes = [];
  $scope.catalogGrouped = [];
  $scope.catalogNonGrouped = [];
  $scope.selected = "";
  $scope.message = "Loading . . . "
  $scope.loadMessage = true;
  $scope.states = [];
  $scope.catalogBoth;

  $scope.init = function() {
    $scope.loadData();
  }

  $scope.loadData = function() {
    $scope.loadMessage = true;
    dataProvider.loadData(function(response) {
      $scope.institutions = response.data;
      const map = new Map();
      $scope.institutions.forEach(function(i) {
        if(!map.has(i.description)) {
          map.set(i.description, true);
          $scope.sources.push(i);
        }
        if($scope.states.indexOf(i.stateProvince) < 0) {
          $scope.states.push(i.stateProvince);
        }
      })

      $scope.states.sort();

      $scope.sources.forEach(function(i) {
        switch(i.code) {
          case "4867":
            i.description = "University of Hawaii at Manoa";
            break;
          case "4869":
            i.description = "University of Hawaii at Hilo";
            break;
          case "1042":
            i.description = "University of Hawaii West Oahu";
            break;
          case "1801":
            i.description = "Hawaii Community College";
            break;
          case "4350":
            i.description = "Honolulu Community College";
            break;
          case "4377":
            i.description = "Kapiolani Community College";
            break;
          case "4378":
            i.description = "Kauai Community College";
            break;
          case "4410":
            i.description = "Leeward Community College";
            break;
          case "4510":
            i.description = "Univ of Hawaii Maui College";
            break;
          case "4976":
            i.description = "Windward Community College";
          default:
        }
      })
      $scope.load($scope.sources);
      console.log($scope.institutions)
    }, institutionUrl);
  }

  $scope.loadSubjects = function(source) {
    $scope.loadMessage = true;
    $scope.subjects = [];
    var url = "api/sourceCatalog/source/" + source + "/subjects";
    dataProvider.loadData(function(response) {
      $scope.subjects = response.data;
      $scope.subjects.sort();
      $scope.load($scope.subjects)
    }, url);
  }

  $scope.loadTargets = function(source, subject) {
    $scope.loadMessage = true;
    $scope.targets = [];
    $scope.filtered = [];
    const map = new Map();
    $scope.institutions.forEach(function(i) {
      if(!map.has(i.mifDescription) && i.code === source) {
        map.set(i.mifDescription, true);
        $scope.targets.push(i);
      }
    })

    $scope.filtered = $scope.catalogNonGrouped.filter(function(c) {
      return c.subjectCodeTrans === subject;
    })

    for(var t = 0; t < $scope.targets.length; t++) {
      if(!($scope.filtered.some(course => course.mifValue === $scope.targets[t].mifValue))) {
        $scope.targets.splice(t, 1);
        t -= 1;
      }
    }

    $scope.targets.sort((a,b) => a.mifDescription.localeCompare(b.mifDescription));
    $scope.load($scope.targets);
    console.log($scope.targets);
  }

  $scope.loadCatalogNonGrouped = function(source, subject) {
    $scope.filtered = [];
    $scope.catalogNonGrouped = [];
    $scope.available = [];
    $scope.loadMessage = true;
    var catalogUrl = "api/catalogNonGrouped/source/" + source + "/subject/" + subject;
    dataProvider.loadData(function(response) {
      $scope.catalogNonGrouped = response.data;
      Array.prototype.push.apply($scope.filtered, $scope.catalogNonGrouped);
      console.log($scope.catalogNonGrouped);
      $scope.loadTargets(source, subject);
      $scope.load($scope.catalogNonGrouped);
    }, catalogUrl)
  }

  $scope.loadCatalogGrouped = function(source, target, subject) {
    $scope.catalogGrouped = [];
    $scope.available = [];
    $scope.loadMessage = true;
    var catalogUrl = "api/catalogGrouped/source/" + source + "/target/" + target + "/subject/" + subject;
    dataProvider.loadData(function(response) {
      $scope.catalogGrouped = response.data;
      Array.prototype.push.apply($scope.filtered, $scope.catalogGrouped);
      console.log($scope.catalogGrouped)
      $scope.loadCatalogBoth(source, target, subject);
      $scope.load($scope.catalogGrouped);
    }, catalogUrl)
  }

  $scope.loadCatalogBoth = function(source, target, subject) {
    $scope.catalogBoth = [];
    $scope.available = [];
    $scope.loadMessage = true;
    var catalogUrl = "api/sourceCatalogBoth/source/" + source + "/target/" + target + "/subject/" + subject;
    dataProvider.loadData(function(response) {
      $scope.catalogBoth = response.data;
      $scope.catalogBoth.forEach(function(c) {
        $scope.catalogGrouped.forEach(function(g) {
          if(c.transGroupConnector === g.transGroupConnector) {
            g.courseNumberTrans += "<br/>" + c.courseNumberTrans;
            g.courseTitleTrans += "<br/>" + c.courseTitleTrans;
          }
        })
      })
      console.log($scope.catalogBoth)
      $scope.loadAttributes(source, target, subject);
      $scope.load($scope.catalogBoth);
    }, catalogUrl)
  }

  $scope.filterCourses = function(target) {
    $scope.available = [];
    console.log($scope.filtered);
    $scope.filtered.forEach(function(c) {
      if ($scope.available.indexOf(c) < 0 && c.mifValue === target) {
        var filteredAttributes = $scope.filterAttributes(c);
        $scope.available.push({sourceInstitutionCode: c.sourceInstitutionCode, mifValue: c.mifValue,
          academicPeriodStart: c.academicPeriodStart, subjectCodeTrans: c.subjectCodeTrans,
          courseNumberTrans: c.courseNumberTrans, courseTitleTrans: c.courseTitleTrans,
          equivCourse: [{subject: c.subjectCodeEquiv, course: c.courseNumberEquiv,
            sequenceNumber: c.sequenceNumber, connector: c.connector} ],
          equivCreditsUsed: c.equivCreditsUsed, transGroupConnector: c.transGroupConnector,
          transGroupPrimaryInd: c.transGroupPrimaryInd,
          attributes: filteredAttributes});
      }
    });

    if($scope.available.length > 0) {
      $scope.available.forEach(function (c) {
        $scope.findConnectedCourseRecursive(c);
      })

      $scope.available.sort((a, b) => a.courseNumberTrans.localeCompare(b.courseNumberTrans));
    }
    $scope.load($scope.available);
    console.log($scope.available)
  }

  $scope.loadAttributes = function(source, target, subject) {
    $scope.available = [];
    var attributeUrl = "api/courses/source/" + source + "/target/" + target + "/subject/" + subject;
    dataProvider.loadData(function(response) {
      $scope.attributes = response.data;
      $scope.filterCourses(target);
    }, attributeUrl)
  }

  $scope.filterAttributes = function(course) {
    var filteredAttributes = [];
    var temp = $scope.attributes.filter(function (a) {
      return a.sourceInstitutionCode === course.sourceInstitutionCode
        && a.mifValue === course.mifValue
        && a.subjectCodeTrans === course.subjectCodeTrans
        && a.courseNumberTrans === course.courseNumberTrans
        && course.subjectCodeEquiv.includes(a.subjectCodeEquiv)
        && course.courseNumberEquiv.includes(a.courseNumberEquiv)
        && a.academicPeriodStart === course.academicPeriodStart
    })

    const map = new Map();
    temp.forEach(function(a) {
      if(!map.has(a.equivCourseAttribute)) {
        map.set(a.equivCourseAttribute, true);
        filteredAttributes.push(a);
      }
    })
    filteredAttributes.sort((a,b) => a.equivCourseAttribute.localeCompare(b.equivCourseAttribute));
    return filteredAttributes;
  }

  $scope.showCourse = function(course) {
    $scope.course = course;

    if (course.attributes.length > 0) {
      $scope.courseAttr = course.attributes;
      $("#course").modal();
    }
  }

  $scope.load = function(arr) {
    if (arr.length === 0) {
      $scope.message = "No results.";
      $scope.loadMessage = true;
    } else {
      $scope.message = "Loading . . .";
      $scope.loadMessage = false;
    }
  }

  $scope.findConnectedCourseRecursive = function(course) {
    var values = $scope.findConnectedCourseHelper(course, course.equivCourse[0].sequenceNumber + 1);
    course.equivCourse = values.equivCourse;
    course.equivCreditsUsed = values.credits;
  }

  $scope.findConnectedCourseHelper = function(course, sequence) {
    $scope.available.forEach(function(c) {

      if (c.sourceInstitutionCode === course.sourceInstitutionCode
        && c.mifValue === course.mifValue
        && c.subjectCodeTrans === course.subjectCodeTrans
        && c.courseNumberTrans === course.courseNumberTrans
        && c.courseTitleTrans === course.courseTitleTrans
        && c.academicPeriodStart === course.academicPeriodStart
        && c.transGroupPrimaryInd === course.transGroupPrimaryInd
        && c.equivCourse[0].sequenceNumber === sequence) {
        var values = $scope.findConnectedCourseHelper(c, sequence + 1);

        if(values.equivCourse[0].connector === "A") {
          values.equivCourse[0].connector = "AND";
          course.equivCreditsUsed += values.credits;
        } else {
          values.equivCourse[0].connector = "OR";
        }

        var includes = false;
        course.equivCourse.forEach(function(c) {
          values.equivCourse.forEach(function(v) {
            if(c.sequenceNumber === v.sequenceNumber && c.connector === v.connector) {
              includes = true;
            }
          })
        })

        if(!includes) {
          Array.prototype.push.apply(course.equivCourse, values.equivCourse);
          $scope.available = $scope.available.filter(function(currentCourse) {
            return currentCourse !== c;
          })
        }
      }
    })
    return {equivCourse: course.equivCourse, credits: course.equivCreditsUsed};
  }

  $scope.headerColor = function(inst) {
    switch(inst) {
      case "MAN":
        $scope.color = "man";
        break;
      case "HIL":
        $scope.color = "hil";
        break;
      case "WOA":
        $scope.color = "woa";
        break;
      case "HAW":
        $scope.color = "haw";
        break;
      case "HON":
        $scope.color = "hon";
        break;
      case "KAP":
        $scope.color = "kap";
        break;
      case "KAU":
        $scope.color = "kau";
        break;
      case "LEE":
        $scope.color = "lee";
        break;
      case "MAU":
        $scope.color = "mau";
        break;
      case "WIN":
        $scope.color = "win";
      default:
    }
  }
}

creditxferApp.factory("dataProvider", function($http, $log) {
  return {
    loadData: function(callback, url) {
      $http.get(encodeURI(url)).then(callback, function(data, status) {
        $log.error("Error in dataProvider; status: ", status);
      });
    }
  };
});

creditxferApp.controller("CreditxferJsController", CreditxferJsController);

creditxferApp.filter("propsFilter", function() {
  return function(items, props) {
    var out = [];
    if(!props.description.length){
      return out;
    }

    if (angular.isArray(items)) {
      items.forEach(function(item) {
        var itemMatches = false;

        var keys = Object.keys(props);
        for (var i = 0; i < keys.length; i++) {
          var prop = keys[i];
          var text = props[prop].toLowerCase();
          if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
            itemMatches = true;
            break;
          }
        }

        if (itemMatches) {
          out.push(item);
        }
      });
    } else {
      // Let the output be the input untouched
      out = items;
    }

    return out;
  }
});

function FeedbackController($scope){

  $scope.submit = function(form) {

  }
}

creditxferApp.controller("FeedbackController", FeedbackController);

// For ngSanitize deprecated method "lowercase"
angular.module("creditxferApp").config(function() {
  angular.lowercase = angular.$$lowercase;
});

