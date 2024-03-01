import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def data = findTestData('Data Files/akun-list')

def userName = data.getObjectValue('username', 1)

def passWord = data.getObjectValue('password', 1)

def search = data.getObjectValue('searchvalue', 1)

WebUI.callTestCase(findTestCase('Action - Login'), [('username') : userName, ('password') : passWord], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Page_ACME demo app/a_Add Account'), 1)

WebUI.verifyElementPresent(findTestObject('Page_ACME demo app/a_Make Payment'), 1)

WebUI.verifyElementPresent(findTestObject('Page_ACME demo app/h6_Financial Overview'), 1)

WebUI.verifyElementPresent(findTestObject('Page_ACME demo app/h6_Recent Transactions'), 1)

WebUI.setText(findTestObject('Page_ACME demo app/input_text'), search)

WebUI.closeBrowser()

