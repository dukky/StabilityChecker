StabilityChecker
================


Checks stability of your internet connection by processing pings to google.com (Windows only, should be fairly easy to modifiy the regex though).

##Build
    
    cd src
    javac *.java
##Usage

`ping -t google.com | java StabilityChecker`

