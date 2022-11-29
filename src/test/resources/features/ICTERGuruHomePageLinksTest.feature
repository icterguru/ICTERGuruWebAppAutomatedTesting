@ICTERGuruHomePageLinksTest
Feature: ICTERGuru Homepage links Checkup 
As an ICTERGuru Lover, I want to learn about the ICTERGuru services 
 
Background:
	Given I launch the ICTERGuru WebApp home page 
 
Scenario Outline: Selecting different menu links and checking the corresponding page     
	When I selected "<menuLink_text>" link on the menu bar     
	Then I verified the selected menu by the existence of the "<linkedMenuPage_text>" text 
 
    Examples:        
    |menuLink_text|linkedMenuPage_text|
    |Home|ICTER Guru|
    |Tutorials|ICTER Guru Online Forum|
    |Tutors|Contact Your Local IRS Office|
    |Books|C Programming|
    |Journals|ICTER Guru Journal of Humanities and Social Science|
    |Contact|ICTER Guru LLC|
    