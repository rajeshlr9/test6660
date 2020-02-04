$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("E:/eclipse-workspace/SampleMavenPorj/src/test/java/featureFile/MyTest.feature");
formatter.feature({
  "line": 1,
  "name": "Execute Selenium Scripts from LeanFT Tool",
  "description": "I want to use this template for my feature file",
  "id": "execute-selenium-scripts-from-leanft-tool",
  "keyword": "Feature"
});
formatter.before({
  "duration": 200616,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Create Order via Filezilla using Leanft and Resume order in O2S via Selenium(Work on 2 application)",
  "description": "",
  "id": "execute-selenium-scripts-from-leanft-tool;create-order-via-filezilla-using-leanft-and-resume-order-in-o2s-via-selenium(work-on-2-application)",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@tag4"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "Open Filezilla",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "user connects to EMC customer and drop an OB order",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Login to OMS using Selenium",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ],
      "line": 28
    },
    {
      "cells": [
        "867949",
        "Manage16"
      ],
      "line": 29
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Search for the dropped order using Selenium",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "Resume the incomplete order using Selenium",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Order is placed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.LaunchFilezilla()"
});
formatter.result({
  "duration": 3100330689,
  "status": "passed"
});
formatter.match({
  "location": "Steps.orderUpload()"
});
formatter.result({
  "duration": 31084314095,
  "status": "passed"
});
formatter.match({
  "location": "Steps.OMSLogin(DataTable)"
});
formatter.result({
  "duration": 34466874156,
  "status": "passed"
});
formatter.match({
  "location": "Steps.searchOrder()"
});
formatter.result({
  "duration": 34090984799,
  "status": "passed"
});
formatter.match({
  "location": "Steps.resumeOrder()"
});
formatter.result({
  "duration": 125466017574,
  "status": "passed"
});
formatter.match({
  "location": "Steps.orderCreationValidation()"
});
formatter.result({
  "duration": 467709277,
  "status": "passed"
});
formatter.after({
  "duration": 534180242,
  "status": "passed"
});
});