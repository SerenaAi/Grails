MyAuction
=======

A really cool auction for the SENG class

## Configuring Assets ##
My Auction makes use of the Asset Pipeline.

Make sure AngularJS, bower and node are installed on your system. A typical debian install, would be:

    # apt-get install nodejs
    # apt-get install npm
    # npm i -g bower
    
Navigate to grails-app/assets and install AngularJS

    # cd grails-app/assets
    # bower install angular --save

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
A [bug on Grails v2.4.4](http://stackoverflow.com/questions/23978443/grails-rest-with-resource-put-is-not-updating)
still exists that prevents a RESTful call to update a field.
