$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/featureFile/MyTest.feature");
formatter.feature({
  "line": 1,
  "name": "Execute Selenium Scripts from LeanFT Tool",
  "description": "I want to use this template for my feature file",
  "id": "execute-selenium-scripts-from-leanft-tool",
  "keyword": "Feature"
});
formatter.before({
  "duration": 434356,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Complete adhoc move in Putty using Leanft",
  "description": "",
  "id": "execute-selenium-scripts-from-leanft-tool;complete-adhoc-move-in-putty-using-leanft",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 34,
      "name": "@tag5"
    }
  ]
});
formatter.step({
  "line": 36,
  "name": "Open Putty",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "user login to Putty",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "NodeId",
        "NodePassword"
      ],
      "line": 38
    },
    {
      "cells": [
        "yanqarf1",
        "QA36playgnd",
        "Mphasis04",
        "Mphas004"
      ],
      "line": 39
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "Complete adhoc move",
  "rows": [
    {
      "cells": [
        "Start_Location",
        "ItemID",
        "Quantity",
        "SuggestedLoc"
      ],
      "line": 41
    },
    {
      "cells": [
        "STG001R",
        "7181E-01",
        "1",
        "BB2314C3"
      ],
      "line": 42
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "Items are moved successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.openPutty()"
});
formatter.result({
  "duration": 422107939,
  "status": "passed"
});
formatter.match({
  "location": "Steps.puttyLogin(DataTable)"
});
formatter.result({
  "duration": 17748755016,
  "status": "passed"
});
formatter.match({
  "location": "Steps.performAdhocmove(DataTable)"
});
formatter.result({
  "duration": 23929078167,
  "status": "passed"
});
formatter.match({
  "location": "Steps.adhocmoveValidation()"
});
formatter.result({
  "duration": 88101532,
  "status": "passed"
});
formatter.after({
  "duration": 268732,
  "status": "passed"
});
});