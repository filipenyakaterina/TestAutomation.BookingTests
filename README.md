# TestAutomation.BookingTests
Run from command line: mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-all.xml -Denvironment=qa clean test

There are 13 tests in projects. They are
> BasicTests

    checkDeparture:
  
        1. open page https://www.booking.com/
        2. select language 
        3. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        4. press search button
        5. redirect to the page with search results
        6. get the value of the departure field from the search data section on the search results page
        7. compare the value from step 6 with the departure value entered in step 3
      
    checkCheckInDate:
  
        1. open page https://www.booking.com/
        2. select language 
        3. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        4. press search button
        5. redirect to the page with search results
        6. get the value of the check-in-date field from the search data section on the search results page
        7. compare the value from step 6 with the check-in date value entered in step 3
      
    checkCheckOutDate:
  
        1. open page https://www.booking.com/
        2. select language 
        3. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        4. press search button
        5. redirect to the page with search results
        6. get the value of the check-out-date field from the search data section on the search results page
        7. compare the value from step 6 with the check-out date value entered in step 3
      
    checkAdultsCount:
  
        1. open page https://www.booking.com/
        2. select language 
        3. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        4. press search button
        5. redirect to the page with search results
        6. get the value of the adults field from the search data section on the search results page
        7. compare the value from step 6 with the number of adults value entered in step 3
      
    checkChildrenCount:
  
        1. open page https://www.booking.com/
        2. select language 
        3. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        4. press search button
        5. redirect to the page with search results
        6. get the value of the children field from the search data section on the search results page
        7. compare the value from step 6 with the number of children value entered in step 3
      
    checkRoomsCount:
 
        1. open page https://www.booking.com/
        2. select language 
        3. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        4. press search button
        5. redirect to the page with search results
        6. get the value of the rooms field from the search data section on the search results page
        7. compare the value from step 6 with the rooms number value entered in step 3
      
> SortTests
  
    checkSortByPrice:
 
        1. open page https://www.booking.com/
        2. select currency 
        3. select language
        4. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        5. press search button
        6. redirect to the page with search results
        7. press button "Price(lowest first)" on the sort bar
        8. check if the list of search results is sorted in ascending order of price
        
        
    checkSortByStarsCount:
 
        1. open page https://www.booking.com/
        2. select currency 
        3. select language
        4. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        5. press search button
        6. redirect to the page with search results
        7. press button "Stars" on the sort bar
        8. select option "stars[5 to 1]" on the drop-down list
        9. check if the list of search results is sorted in descending order of number of stars
        
    checkSortByDistance:
 
        1. open page https://www.booking.com/
        2. select currency 
        3. select language
        4. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        5. press search button
        6. redirect to the page with search results
        7. open drop-down list on the sort bar
        8. choose option "Distance From Downtown" on the drop-down list 
        9. check if the list of search results is sorted in ascending order of distances from city center
        
> FilterTests    

    checkFilterByPrice:
 
        1. open page https://www.booking.com/
        2. select currency 
        3. select language
        4. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        5. press search button
        6. redirect to the page with search results
        7. switch option "Set your own budget" on the filter bar
        8. set budget range according to the values of min-price-per-night and max-price-per-night fields in properties-file
        9. check if the list of filtered results consists of items with price in range from min price per night multiplied 
        by the number of days to max price per night multiplied by the number of days
           
    checkFilterByReviewScore:
 
        1. open page https://www.booking.com/
        2. select currency 
        3. select language
        4. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        5. press search button
        6. redirect to the page with search results
        7. check "Review Score" option on the filter bar according to the value of review-score field in the properties-file
        8. check if the list of filtered results consists of items with score not less than value of review score from step 7
                   
    checkFilterByStarRating:
 
        1. open page https://www.booking.com/
        2. select currency 
        3. select language
        4. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        5. press search button
        6. redirect to the page with search results
        7. check "Star Rating" option on the filter bar according to the value of star-rating field in the properties-file
        8. check if the list of filtered results consists of items with stars number equal to value of star rating from step 7
      
    checkFilterByDistance:
 
        1. open page https://www.booking.com/
        2. select currency 
        3. select language
        4. enter data values for searching booking (departure, check-in date, check-out date, number of adults,
        number of children, rooms number) according to the test data in properties-file(dev.properties, qa.properties)
        5. press search button
        6. redirect to the page with search results
        7. check "Distance from center of city" option on the filter bar according to the value of distance field in the properties-file
        8. check if the list of filtered results consists of items with distance from downtown no more than value of distance from step 7
        
