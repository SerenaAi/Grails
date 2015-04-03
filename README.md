MyAuction
=======

A really cool auction for the SENG class

## How to Run it ##
In order to run the app, do the following:

    grails run-app

## How to Test it ##

    grails -Dgeb.env=chrome test-app

**Note** that the functional test makes use of the `Chrome` or `Firefox`
driver. On a Linux box, the above command should run fine. On a Mac you may
need to specify the path to the `Chrome` driver, this can be done as follows:

    grails -Dgeb.env=chrome -Dwebdriver.chrome.driver=/Downloads/chromedriver test-app

The chrome driver for a Mac can be found [here](http://chromedriver.storage.googleapis.com/index.html?path=2.14/)

### Notes ###
A [bug on grails](https://jira.grails.org/browse/GRAILS-11462) exists that 
prevents a RESTful call to update a field.
