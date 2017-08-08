# msa-testng-appium

<b>How to set up:</b>
<ul>
<li>Install geny motion and create virtual device
<li>Install geny motion and create virtual device
<li>Install android sdk in your machine , find the virtual device on machine (adb devices)
<li>Install your app (selendroid) on connected device (adb install <sample.apk>)
<li>Provide  the path of apk file on your machine in properties file
<li>Provide the name of your device in properties file
<li>Then run the Test Runner class
</ul>


How to write tests :

define feature file
place your mobile screen objects in form of yaml files under page objects
write step definition (definition should use helper function (key) to call action and provide in util and should provide referance of screen and locator)
pleas echeck the sample test feature and it respective definition.
