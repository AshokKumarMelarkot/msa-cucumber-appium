# msa-testng-appium

<b>How to set up:</b>
<ul>
<li>Install geny motion and create virtual device
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29074321-76b0d428-7c6c-11e7-901e-958e18d64223.png" height="42" width="42">
<li>Install android sdk in your machine , find the virtual device on machine (adb devices)
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29074327-7e05706c-7c6c-11e7-9715-461185f8e029.png">
<br><br>
<li>Install your app (selendroid) on connected device (adb install selendroid.apk)
<li>Start the Appium server and make sure your virtual device is up and running
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29074332-83f2bfac-7c6c-11e7-9da2-c2130562f1ca.png">
<br><br>
<li>Provide  the path of apk file on your machine in properties file
<li>Provide the name of your device in properties file located in src/main/resources/conf.properties
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29074341-8dfe2dc4-7c6c-11e7-9ad2-6af711ca19ec.png">
<li>Then run the Test Runner class
<li>The test creates the regular html report and extended report as well
<br><br>
<img src="https://user-images.githubusercontent.com/19589895/29074351-96a0b726-7c6c-11e7-81a9-975de910163d.png">
<img src="https://user-images.githubusercontent.com/19589895/29074366-9ea882a0-7c6c-11e7-9536-c7abbb42dd0f.png">
</ul>


How to write tests :

define feature file
place your mobile screen objects in form of yaml files under page objects
write step definition (definition should use helper function (key) to call action and provide in util and should provide referance of screen and locator)
pleas echeck the sample test feature and it respective definition.
