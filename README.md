# Android_Assignment_FamPay
AAL3 Android Assignment

NOTE: APK is atttached to the repo named as "app-debug.apk"

## TimeLine I followed

https://docs.google.com/document/d/1YPnDBpoSKKbEswE4CQFzVRUs9BX5biytRbsrJGiM_Ec/edit?usp=sharing

## Application Screens

<span><img src="https://i.imgur.com/lThFfuc.jpg" width="150px"/></span>
<span><img src="https://i.imgur.com/lVHTxZR.jpg" width="150px"/></span>
<span><img src="https://i.imgur.com/dsjr2qv.jpg" width="150px"/></span>
<span><img src="https://i.imgur.com/tzejX1o.jpg" width="150px"/></span>
<span><img src="https://i.imgur.com/jEd11jw.jpg" width="150px"/></span>

## Libraries/Dependencies Used:

* Retrofit
* Moshi
* Epoxy
* Glide
* SwipeRefreshLayout
* DataBinding
* Androidx Lifecycle

## My Progress at the time of Submission

### Task Completed:

* All deep links (card, CTAs, Formatted Text entities) should be handled.
* In the API, almost every component has its own URL/deep link that is used to trigger action on click.
* Click on Big Display Card (HC3) is sliding to the right and displaying action buttons as per the design.
* On tapping the "remind later" action on a card, it should be removed from the display. This card should be shown on the next app start.
* On tapping the "dismiss now" action, it should be removed from the display. This card would never be visible again as the state is saved in shared Preference.
* Implement swipe down to refresh feature 
* Handle loading and error states with errors are logged on the console
* Write structured code with flexible and reusable components using Epoxy with data binding to replace the large and hectic handling of multiple adapters
* Tried to match the design as closely as possible to the one on Figma

### Some Issues Left: 

* On click is used in place of LongPress.
* HC9 height value is not added - it is wrapped content instead
* isScrollable = false is not handled – the same UI for both cases.
* Gradients are not added

