# Performance Statistics Asset - Java Libraries

The performance statistics asset is a software library intended for server side use. The library can be used to detect player’s performance in games as well as identify individual players that are underperforming compared to a group of players. This asset is able to detect performance in real-time. It provides a library of classes for computing group performance, detecting individual performance, comparing individuals to groups, and comparing groups to each other.

Game designers or game developers can use this asset for instance in generating feedback for students individual study or for teachers that support students. The asset can also be used to compare performance between game levels for game testing and optimization purposes. This asset can be easily integrated in any java application where data for groups of users is available. The input for asset should be a series of scores if group performance is computed or the score of individual users if group performance has already been computed and individual performance is being evaluated.

## License
This asset uses the Apache-2 open source license, which means that everybody can use it for free, even in commercial application.

## Requirements
1.	This asset requires Integration in a Java application
2.	For performance computations, scores should be fed into the asset. The scores can only be values at interval level (of double precision). The asset cannot process categorical values.

## Download and import
In order to use the performance statistics asset in a Java application you need to follow the following instructions:
1.	download the asset. The URL can be found here: https://github.com/rageappliedgame/performancestatisticsjavalibraries
•	Note: all the above mentioned asset will be downloaded as ZIP files if you press on the "Clone or download" button and then press on the "Download ZIP" link on each page belong to each asset.


Figure 1.

## Setup Project for Exercises
1.	After you have downloaded all the asset mentioned above, you need to extract them on your computer.
2.	Navigate to your chosen folder and then the sub-folder called ‘dist’. Here you will find the file ‘PerformanceStiatisticsLibrary.jar’.
3.	Open the project you want to include performance statistics in and import the jar library. The library’s classes should now be available for use.

## Troubleshooting/FAQ
1.	Be sure to catch the errors thrown by the classes in. There are no hard safeguards against submitting null values or objects.
2.	The class library includes integrated serialization options for transforming Distribution objects into JSON. You can use this functionality if you want to store instances in a database (for example if you want to protect data against crashes etc.).

# Performance Statistics Asset - use-case example

## Introduction
In this use-case we assume the user has set-up a game that is generating player-scores and sending them to a server. This example assumes that there is a server-side java (web-)application that receives and processes the player-scores one-by-one. The developer is interested in detecting player scores that indicate an ‘at risk’ level of under-performance.

## Setup
1.	Import the library into your server-side system as instructed above.
2.	Setup an instance of the Distribution class for each group you want to compare students or other groups to.
3.	Setup an instance of the DistributionUpdater Class.
4.	Everytime a new datapoint comes in, call the DistributionUpdater and supply it with the score and the Distribution instance you have set up. Make sure you catch input errors here and make sure the incoming scores are of the Double type!
5.	Whenever you want to compare a score to the group average or when you want to compare groups, call the static class DistributionRiskAssessor and supply it with either a score and a distribution or with two distributions. The DistributionRiskAssessor will return a boolean to indicate whether a student is or is not at risk (far below the group mean) or it will return 0, 1, or 2 to indicate whether group one is equal, above, or below group two.

Note: please note that these classes are capable of processing data at high speeds and are suitable for learning analytics and data science purposes.

## Serialization/deserialization
If you need to serialize the Distribution instances you can supply DistributionToJSONSerializationService.serialize with a Distribution instance and it will output valid a JSON string containing instance data. Use DistributionToJSONSerializationService.deserialize to restore a Distribution instance.

## Code examples
Some code examples can be found inside the library unit tests. An example is provided here as well. In this example we are using the performance statistics asset in a web service pipeline. The distribution is updated with each new data point and the resulting risk assessment is committed to a database. It assumes no distributions were previously in the database. 
The code example can be plugged into the point where the web service handles the request.

```
//Create and update a distribution
Distribution distribution = new Distribution();
DistributionUpdater updater = new DistributionUpdater();
Distribution distribution = updater.updateDistribution(distribution, newScore);

//Commit distribution to database
Database.add(DistributionToJSONSerializationService.serialize(distribution));

//Commit risk assessment to database
Database.add(DistributionRiskAssessor.serialize(distribution));
```
