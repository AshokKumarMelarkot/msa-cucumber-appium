# msa-testng-appium

How to set up:

install geny motion and create virtual device
install android sdk in your machine , find the virtual device on machine (adb devices)
install your app (selendroid) on connected device (adb install <sample.apk>)
provide  the path of apk file on your machine in properties file
provide the name of your device in properties file
then run the Test Runner class

How to write tests :

define feature file
place your mobile screen objects in form of yaml files under page objects
write step definition (definition should use helper function (key) to call action and provide in util and should provide referance of screen and locator)
pleas echeck the sample test feature and it respective definition.
