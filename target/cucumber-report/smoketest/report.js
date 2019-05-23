$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("preview.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# new feature"
    },
    {
      "line": 2,
      "value": "# Tags: optional"
    }
  ],
  "line": 5,
  "name": "Validate that every video item has a preview",
  "description": "",
  "id": "validate-that-every-video-item-has-a-preview",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@smoketest"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "go through the videos",
  "description": "",
  "id": "validate-that-every-video-item-has-a-preview;go-through-the-videos",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "open video.yandex.ru",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "type \"фильмы\" value and submit Find button",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "60 items are displayed",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "go through the items with mouse over action and make two screenshots",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "compare screenshots",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.openVideoYaPage()"
});
formatter.result({
  "duration": 10343661078,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "фильмы",
      "offset": 6
    }
  ],
  "location": "MyStepdefs.typeValue(String)"
});
formatter.result({
  "duration": 8015307624,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "60",
      "offset": 0
    }
  ],
  "location": "MyStepdefs.itemResults(int)"
});
formatter.result({
  "duration": 5180814679,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.mouseAllItemsOver()"
});
formatter.result({
  "duration": 245460952456,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.compareScreenshots()"
});
formatter.result({
  "duration": 3746636967,
  "status": "passed"
});
});