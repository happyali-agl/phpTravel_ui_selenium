## Test Suite Execution
=======================================================================

 01. MVN run command for this project:
      * Navigate to project path in the CLI tool and run command : mvn clean install 
        followed by:  mvn test -DxmlFiles=functionalTests.xml
        where
        * mvn clean --> it will delete the target folder from the project
        * mvn install -->
       
                *	It will download all the remaining dependencies according to pom.xml file
                *	It will build the project and run the 'test'

02. In testng file (here functionalTests.xml), we do setting for Execution mode :

		* 	To run test in serial mode: <suite name="Suite" parallel="none"> or <suite name="Suite">
		* 	To run test in parallel mode: <suite name="Suite" parallel="tests">
		* 	To run the "classes" in parallel mode: <suite name="Suite" parallel="classes"> 

03. Way of running script:

      * To parameterize the test run:
          1.  via functionalTest.xml:
              *		Pass parameter as <parameter> from testng.xml when browser is passed to script (i.e. baseClass as @parameter)
          2.  Via command line as mvn run:
              *		To parameterize the test run if via command line:
			Mention the location of the functionalTest.xml file to be used as below config:
                  <suiteXmlFiles>
                    <suiteXmlFile>XMLFiles/functionalTests.xml</suiteXmlFile> OR
                    <suiteXmlFile>XMLFiles/${xmlFiles}</suiteXmlFile>
                  </suiteXmlFiles>

04. User WebdriverManager instead of loading project with specific webdriver.exe
      * WebDriverManager : https://github.com/bonigarcia/webdrivermanager
      
		* This is when you don't want to have driver.exe and manager webdriver automatically
			*	for latest :  WebDriverManager.chromedriver().setup();
			*	for specific version: WebDriverManager.chromedriver().version("2.36")setup();
	
## Pipeline for CI is implemented using CircleCI
======================================================================
	
	* You can find the current running pipeline at https://app.circleci.com/pipelines/github/happyali-agl/phpTravel_ui_selenium
	* Currently it is throwing error as:
		" org.openqa.selenium.WebDriverException: 
			unknown error: failed to change window state to maximized, current state is normal"

## Test Bench Setup with Selenium - Maven - TestNG on Windows machines
======================================================================

01. Install JAVA JDK

02. Setup system variables (verify the setup)

	    Environment Variable : System Variables as 
        * JAVA_HOME and path of jdk
        * Edit PATH Variable -->> ;paste same jdk path with "\bin"
        * Verify: java -version
  
03. Install Maven (Build management tool):

	    * Visit apache maven --> download and click --> binary zip link
	    * create a folder in C:ProgramFiles as "ProjectTools" (or any user specific name)
  
04. Set Maven environment - System variables:

      * M2_HOME: location of maven folder from above folder created
      * M2: location of maven with"\bin"
      * Edit Path variable ---> ;%M2%
      * Verify: mvn -v (in new cmd window)

05. Download IDE (eclipse neon.3 for Java developer) move the downloaded folder to above folder and then install

06. Create Maven project with ArtifactID as the project folder (UIautomation , apiAutomation etc)

07. Set Windows preference in IDE
	  * Maven pref: Window --> Preferences --> Maven --> Installations --> New --> Navigate to folder of Apache Maven (from ProjectTools) 
				and select and finish.
	  * Java: Window --> Preferences -->Java --> Installed JRE's --> Add new directory as the jdk file path and update the "Default VM arguments" as 
      -Dmaven.multiModuleProjectDirectory=M2_HOME (select the jdk checkbox only)

08. Here if you get the "Build Path" error then navigate to 
	Project --> Properties --> Jave Build Path 
				--> Libraries --> Select JRE System Library --> Edit 
						--> Select Alternate JRE as the one set up in above step -- Finish

09. Setup .M2 repo: 
    * Project --> Properties --> Jave Build Path --> Libraries 
								-->click "Add Variable" as M2_REPO and path of "c:\usersaccount..\.m2\repository"
                
10. Now verify that installation is successful:
    * click pom.xml --> Run as --> Maven install --> this should return Build Success message.
    
11. Install TestNG:
    * Help --> Eclipse Marketplace --> search "Testng" --> Testng for eclipse --> check all boxes --> accept license --> Restart Eclipse

	
		



