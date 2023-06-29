package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numberOfRaccoons = 3;
		int numberOfRaccoonsThatLeft = 2;
		int numberOfRaccoonsThatRemain = numberOfRaccoons - numberOfRaccoonsThatLeft;


        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfBees = 3;
		int numberOfFlowers = 5;
		int beesLessThanFlowers = numberOfFlowers - numberOfBees;

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int numberOfPigeonsEatingBreadcrumbs = 1;
		numberOfPigeonsEatingBreadcrumbs++;

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int numberOfOwlsSittingOnFence = 3;
		int newNumbeOfOwlsSittingOnFence = numberOfOwlsSittingOnFence + 2;

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int numberOfBeavers = 2;
		int newNumberOfBeavers = numberOfBeavers - 1;


        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int numOfToucans = 2;
		numOfToucans++;

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numOfSquirrels = 4;
		int numOfNuts = 2;
		int numOfMoreSquirrelsThanNuts = numOfSquirrels - numOfNuts;
        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarter = .25;
		double dime = .10;
		double nickel = .05;
		double moneyFound = (2 * nickel) + quarter + dime;

        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int briersClassNumOfMuffins = 18;
		int macadamsClassNumOfMuffins = 20;
		int flannerysClassNumOfMuffins = 17;
		int totalNumOfMuffins = briersClassNumOfMuffins + macadamsClassNumOfMuffins + flannerysClassNumOfMuffins;
        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		double priceOfYoyo = .24;
		double priceOfWhistle = .14;
		double totalAmountSpent = priceOfWhistle + priceOfYoyo;

        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int numOfLargeMarsh = 8;
		int numOfMiniMarsh = 10;
		int totalNumOfMarsh = numOfLargeMarsh +numOfMiniMarsh;

        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int inchesOfSnowAtHouse = 29;
		int inchesOfSnowAtSchool = 17;
		int differenceOfSnowAmount = inchesOfSnowAtHouse - inchesOfSnowAtSchool;


        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */
		double hiltsMoney = 10.00;
		double toyTruck = 3.00;
		double pencilCase = 2.50;
		double hiltsRemaindingMoney = hiltsMoney - toyTruck - pencilCase;

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int marbleCollection = 16;
		int newMarbleCollection = marbleCollection - 7;

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int seashellCount = 19;
		int seashellTotalDesired = 25;
		int seashellsNeeded = seashellTotalDesired - seashellCount;


        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int balloonCount = 17;
		int numOfGreenBalloons = balloonCount - 8;

        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int numOfBooksOnShelf = 38;
		int newNumOfBooksOnShelf = numOfBooksOnShelf + 10;

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int numOfLegsOnABee = 6;
		int numOfBees = 8;
		int numOfLegsOnEightBees = numOfLegsOnABee * numOfBees;

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double costOfCone = .99;
		double costOfTwoCones = costOfCone * 2;

        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int currentNumOfRocks = 64;
		int numOfRocksForProject = 125;
		int numOfRocksNeeded = numOfRocksForProject - currentNumOfRocks;


        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int numOfCurrentMarbles = 38;
		int newNumOfMarbles = numOfCurrentMarbles -15;

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int numOfMilesToConcert = 78;
		int numOfMilesLeft = numOfMilesToConcert - 32;

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int morningSnowTime = 90;
		int afternoonSnowTime = 45;
		int toalAmountOfTime = morningSnowTime + afternoonSnowTime;

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int amountHotdogs = 6;
		double costOfHotdog = .50;
		double totalPriceForHotdogs = costOfHotdog * amountHotdogs;

        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int costOfPencils = 7;
		int hiltsPencilMoney = 50;
		int pencilsSheCanBuy = hiltsPencilMoney/costOfPencils;


        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int allButterflies = 33;
		int redButterflies = allButterflies - 20;

        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double katesMoney = 1.00;
		double candyCost = .54;
		double changeGiven = katesMoney - candyCost;

        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int treeCount = 13;
		int newTreeCount = treeCount + 12;

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int hoursInADay = 24;
		int numOfDays = 2;
		int amountOfTimeUntilGranny = hoursInADay * numOfDays;

        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int cousinAmount = 4;
		int gumForEachCousin = 5;
		int toalGumNeeded = cousinAmount * gumForEachCousin;

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double dansMoney = 3.00;
		double candyBarCost = 1.00;
		double moneyLeftForDan = dansMoney - candyBarCost;

        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsInLake = 5;
		int peopleInEachBoat = 3;
		int peopleOnTheLake = boatsInLake * peopleInEachBoat;

        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellensLegoAmount = 380;
		int ellensNewLegoAmount = ellensLegoAmount - 57;

        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int bakedMuffins = 35;
		int muffinGoal = 83;
		int muffinsNeededForGoal = muffinGoal - bakedMuffins;

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayonCount = 1400;
		int lucyCrayonCount = 290;
		int diffOfCrayonsBetweenLucyAndWilly = willyCrayonCount - lucyCrayonCount;

        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickerPageCount = 10;
		int pageCount = 22;
		int sumOfStickers = stickerPageCount * pageCount;

        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double cupcakeAmount = 100.00;
		double childrenAmount = 8.00;
		double cupcakesForEachKid = cupcakeAmount/childrenAmount;

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int gingerbreadCookies = 47;
		int holdingAmountForJars = 6;
		int cookiesNotInJars = gingerbreadCookies%holdingAmountForJars;

        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int croissantAmount = 59;
		int neighborAmount = 8;
		int leftoverCroissants = croissantAmount%neighborAmount;

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int cookiesOnTray = 12;
		int amountOfCookiesNeeded = 276;
		int amountOfTraysNeeded = amountOfCookiesNeeded/cookiesOnTray;

        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int pretzelTotal = 480;
		int servingOfPretxel = 12;
		int numOfServings = pretzelTotal/servingOfPretxel;

        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int lemonCakeTotal = 53;
		int cakesLeftHome = 2;
		int cakesGivenAway = (lemonCakeTotal - cakesLeftHome)/3;

        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrotStickAmount = 74;
		int peopleForCarrots = 12;
		int leftoverCarrots = carrotStickAmount%peopleForCarrots;

        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int teddybearAmount = 98;
		int shelfAmountMax = 7;
		int filledShelves = teddybearAmount/shelfAmountMax;

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int albumPicLimit = 20;
		int picTotal = 480;
		int albumsNeeded = picTotal/albumPicLimit;

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int tradingCardAmount = 94;
		int tradingBoxLimit = 8;
		int boxesFilled = tradingCardAmount/tradingBoxLimit;
		int cardsLeftover = tradingCardAmount%tradingBoxLimit;

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int bookTotal = 210;
		int shelfTotal = 10;
		int booksOnAShelf = bookTotal/shelfTotal;

        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double croissantsAmount = 17.00;
		double guestAmount = 7.00;
		double croissantForEachGuest = croissantsAmount/guestAmount;

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
     	double rateForBill = 1/2.15;
		double rateForJill = 1/1.90;
		double totalTimeForBothRooms = 5/(rateForBill + rateForJill);

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String fName = "Grace";
		String lName = "Hopper";
		String mInitial = "B";
		String fullName = (lName + ", " + fName + " " + mInitial + ".");


	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */

		double yAre = 800.00;
		double xOr = 537.00;
		double zAnd = xOr/yAre*100;

	}

}
