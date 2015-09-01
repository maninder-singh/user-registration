package com.imaginea.user_registration.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserDaoTest.class, UserRegistrationControllerTest.class, UserRegistrationServiceTest.class })
public class JunitTestSuite {

}
