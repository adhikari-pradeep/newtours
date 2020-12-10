pipeline
{
	agent any
	stages
	{
		stage('Build')
		{
			steps
			{
				echo "Build is Started"
				bat "mvn clean package -PRegression -DskipTests=true"
				echo "Build is Successful"
			}
		}
		stage('SonarQube Analysis')
		{
			steps
			{
				echo "SonarQube Test is Started"
				bat 'mvn sonar:sonar -Dsonar.projectName=MavenHybridFramework -Dsonar.host.url=http://localhost:9000 -Dlicense.skip=true'
				echo "SonarQube Test is Successful"
			}
		}
		stage('Smoke TestSuite')
		{
			parallel
			{
				stage('Chrome')
				{
					steps
					{
						echo "Smoke Test Execution is Started in Chrome"
						bat "mvn test -PSmoke -DBrowser=Chrome"
						echo "Smoke Test Execution is Successful in Chrome"
					}
				}
				stage('Firefox')
				{
					steps
					{
						echo "Smoke Test Execution is Started in Firefox"
						bat "mvn test -PSmoke -DskipTests=true"
						echo "Smoke Test Execution is Successful in Firefox"
					}
				}
			}
		}
		stage('Regression TestSuite')
		{
			parallel
			{
				stage('Chrome')
				{
					steps
					{
						echo "Regression Test Execution is Started in Chrome"
						bat "mvn test -PRegression -DBrowser=Chrome"
						echo "Regression Test Execution is Successful in Chrome"
					}
				}
				stage('Firefox')
				{
					steps
					{
						echo "Regression Test Execution is Started in Firefox"
						bat "mvn test -PRegression -DskipTests=true"
						echo "Regression Test Execution is Successful in Firefox"
					}
				}
			}
		}