# Stibo cloud test automation interview task

This is template for coding task to be done prior interview

## TASK
- write automated test (using Selenium) to cover the following scenario
- use page object pattern
- please use Java
- deliver code as pull request to this repository (please rembemer that on github you need to fork repo first)

### SCENARIO
- go to https://www.sherwin-williams.com/ (it is using Angular on front end, not our product)
- click "Shop Products & Color"
- hover "For Homeowners paints, stains, & supplies" on overlaying popup
- click "Paint" under "Home Interiors >"
- search for "tuberose paint" in search input at the top
- click on searched product "SW 6578 | tuberose | interior/exterior"
- verify you are on the right page by checking url part: "https://www.sherwin-williams.com/homeowners/color/find-and-explore-colors/paint-colors-by-family/SW6578-tuberose"
- verify product name is displayed "SW 6578 Tuberose" (not in breadcrumbs)
- click "DETAILS" tab
- verify "Hex Value: #d47c8c" (just verify string value)
- click "View All Red Paint Colors" link (above hex value)
- search for "tuberose" in "search by color name or number" input field (there are two search inputs, use one in the center of the page)
- verify "Title" attribute from "View Details" link in the tuberose rectangle (as property) if it matches "View details for SW 6578 Tuberose"

- open new tab
- navigate to: https://www.sherwin-williams.com/homeowners/color/find-and-explore-colors/paint-colors-by-family/SW6578-tuberose
- verify product name is displayed "SW 6578 Tuberose" (same step as before)
- close browser

GOOD LUCK!
