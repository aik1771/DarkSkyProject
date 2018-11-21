DarkSky project

Steps for ticket https://technosoft-usa.atlassian.net/browse/FA2-155

1. To run the project, in the steps folder run TestRunner.java class.
2. How I build the testing framework.

     * PageFunction class has a function public static String getHours(int range) this function
       returns the time in hours and pm or am, using the Date Java library. a getData function would pass
       the number of hours increments.
       
     * PageFunction class has a function public static void getData() this function loops through getHours element to collect      the times.
     * After the time captured on darksky.com site, there is an if statemnt to check if the time on darksky.com matcheds the         time from the date function.
