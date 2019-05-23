# new feature
# Tags: optional
@smoketest

Feature: Validate that every video item has a preview

  Scenario: go through the videos
    Given open video.yandex.ru
    When type "фильмы" value and submit Find button
    And 60 items are displayed
    And go through the items with mouse over action and make two screenshots
    Then compare screenshots
#вместо 60 проставить регулярку

