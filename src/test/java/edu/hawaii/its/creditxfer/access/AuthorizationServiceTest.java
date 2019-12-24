package edu.hawaii.its.creditxfer.access;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class AuthorizationServiceTest {

    @Autowired
    private AuthorizationService authorizationService;

    @Test
    public void basics() {
        assertNotNull(authorizationService);
    }

    @Test
    public void fetch() {
        RoleHolder roleHolder = authorizationService.fetchRoles("19407388");
        assertThat(roleHolder.size(), equalTo(1));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertFalse(roleHolder.contains(Role.ADMIN));

        roleHolder = authorizationService.fetchRoles("10336801");
        assertThat(roleHolder.size(), equalTo(1));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertFalse(roleHolder.contains(Role.ADMIN));

        roleHolder = authorizationService.fetchRoles("10000004");
        assertThat(roleHolder.size(), equalTo(1));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertFalse(roleHolder.contains(Role.ADMIN));

        roleHolder = authorizationService.fetchRoles("10000005");
        assertThat(roleHolder.size(), equalTo(1));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertFalse(roleHolder.contains(Role.ADMIN));

        roleHolder = authorizationService.fetchRoles("90000009");
        assertThat(roleHolder.size(), equalTo(1));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertFalse(roleHolder.contains(Role.ADMIN));

        roleHolder = authorizationService.fetchRoles("10000006");
        assertThat(roleHolder.size(), equalTo(1));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertFalse(roleHolder.contains(Role.ADMIN));

        roleHolder = authorizationService.fetchRoles("11668149");
        assertThat(roleHolder.size(), equalTo(1));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertFalse(roleHolder.contains(Role.ADMIN));

        roleHolder = authorizationService.fetchRoles("89999999");
        assertThat(roleHolder.size(), equalTo(2));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertTrue(roleHolder.contains(Role.ADMIN));
    }
}
