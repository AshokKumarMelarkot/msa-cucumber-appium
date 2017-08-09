# msa-cucumber-appium
<b font-size=10>Framework to test native apps using testng-cucumber-selenium along with appium server and genymotion emulator</b>

<b>How to write tests :</b>
<ul>
<li>Define feature file (src/main/resources/pageObjects)
<br>
<img src="https://user-images.githubusercontent.com/19589895/29115988-1775c21a-7d17-11e7-9c0f-2fa9455b0aed.png" height="400" width="600">
<li>Place your mobile screen objects in form of yaml files under page objects (src/main/resources/pageObjects)
<br>
<img src="https://user-images.githubusercontent.com/19589895/29115996-1d1ab8d8-7d17-11e7-990f-6509203f4d9b.png" height="400" width="600">
<li>Write step definition
(definition should use helper function (key) to call action and provide in util and should provide reference of screen and locator)
<br>
<img src="https://user-images.githubusercontent.com/19589895/29116005-24e35944-7d17-11e7-8de6-3d97359c45f2.png" height="400" width="600">
<li>Run the TestRunner calss as testng class or run testng.xml or sample.feature file.
<br>
<img src="https://user-images.githubusercontent.com/19589895/29116026-2e73660c-7d17-11e7-918b-e23dc2ecba7a.png" height="400" width="600">
<br><br>
<li>The test creates the regular html report and extended report as well
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29116400-49bfc422-7d18-11e7-8ef5-c26383eba111.png" height="400" width="600">
<img src="https://user-images.githubusercontent.com/19589895/29116373-32abe126-7d18-11e7-88b1-e2fd88dab007.png" height="400" width="600">
</ul>
<br>
<br>
<br>
<b>How to set up:</b>
<ul>
<li>Install geny motion and create virtual device
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29074321-76b0d428-7c6c-11e7-901e-958e18d64223.png" height="400" width="600">
<li>Install android sdk in your machine , find the virtual device on machine (adb devices)
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29074327-7e05706c-7c6c-11e7-9715-461185f8e029.png" height="400" width="600">
<br><br>
<li>Install your app (selendroid) on connected device (adb install selendroid.apk)
<li>Start the Appium server and make sure your virtual device is up and running
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29074332-83f2bfac-7c6c-11e7-9da2-c2130562f1ca.png" height="400" width="600">
<br><br>
<li>Provide  the path of apk file on your machine in properties file
<li>Provide the name of your device in properties file located in src/main/resources/conf.properties
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29074341-8dfe2dc4-7c6c-11e7-9ad2-6af711ca19ec.png" height="400" width="600">
<li>Then run the Test Runner class
<li>The test creates the regular html report and extended report as well
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29074351-96a0b726-7c6c-11e7-81a9-975de910163d.png" height="400" width="600">
<img src="https://user-images.githubusercontent.com/19589895/29074366-9ea882a0-7c6c-11e7-9536-c7abbb42dd0f.png" height="400" width="600">
</ul>


