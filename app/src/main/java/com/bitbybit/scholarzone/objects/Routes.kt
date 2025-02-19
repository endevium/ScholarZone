package com.bitbybit.scholarzone.objects

object Routes {
    val LandingPage = "LandingPage"
    val LoginPage = "LoginPage"
    val SignupPage = "SignUpPage"
    val SignupPageTwo = "SignUpPageTwo"
    val SignupPageThree = "SignUpPageThree"
    val ForgotPassword = "ForgotPassword"
    val ForgotPasswordTwo = "ForgotPasswordTwo"
    val MainPage = "MainPage"
    val HomePage = "HomePage"
    val DashboardPage = "DashboardPage"
    val NotificationPage = "NotificationPage"
    val ProfilePage = "ProfilePage"

    const val ScholarshipApplicationPage = "scholarshipApplicationPage/{id}/{application_name}/{company}/{application_description}/{duration}/{category}/{slots}/{deadline}"
    val ApplicationFormPage = "applicationFormPage/{scholarship_application_id}/{application_name}/{company}/{application_description}/{duration}/{category}/{slots}/{deadline}"
    val SearchPage = "SearchPage"

    val PersonalDetailsPage = "PersonalDetailsPage"
    val AccountDetailsPage = "AccountDetailsPage"

    val EditFirstNamePage = "EditFirstNamePage"
    val EditLastNamePage = "EditLastNamePage"
    val EditGenderPage = "EditGenderPage"
    val EditBirthdatePage = "EditBirthdatePage"
    val EditSchoolPage = "EditSchoolPage"
    val EditProgramPage = "EditProgramPage"
    val EditPhoneNumberPage = "EditPhoneNumberPage"
    val EditRPCPage = "EditRPCPage"
    val EditBSBPage = "EditBSBPage"

    val EditUsernamePage = "EditUsernamePage"
    val EditEmailPage = "EditEmailPage"
    val EditPasswordPage = "EditPasswordPage"
}