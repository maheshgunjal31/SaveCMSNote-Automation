package dataproviders;

import org.testng.annotations.DataProvider;

public class SaveCMSNoteDataProvider {

    @DataProvider(name = "saveCMSData")
    public Object[][] saveCMSData() {

        return new Object[][]{

                {"TC01","Sample Note added to claimant 4235807 by Mahesh",
                        "4713992","4235807","",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC02","MaheshGunjal_AddedUpdatedNote",
                        "4713992","4235807","",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC03","Note_Added_to_Claimant & Docker_by Mahesh",
                        "4713993","4235809","88433475",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC04","Note_Added_to_Claimant & Docker_by Mahesh",
                        "4713993","4235809","88433475",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC05","Note_Added_to_Claimant & Docker_by Mahesh",
                        "8888888","","",true,
                        400,400,
                        null,
                        "Claim does not Exist for CMSClaimId 8888888"},

                {"TC06","Note_Added_to_Claimant & Docker_by Mahesh",
                        "AbC1234@","","",true,
                        200,400,
                        null,
                        "Conversion failed"},

                {"TC07","Note_Added_to_Claimant & Docker_by Mahesh",
                        "","4235809","",true,
                        400,400,
                        null,
                        "Please provide CMSClaimId"},

                {"TC08","Note_Added_to_Claimant & Docker_by Mahesh",
                        "","","88433475",true,
                        400,400,
                        null,
                        "Please provide CMSClaimId"},

                {"TC09","String Value as true in SendNotification node",
                        "4713994","","","true",
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC10","String Value as true in SendNotification node",
                        "4713994","","","false",
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC11","Numeric One",
                        "4713994","","",1,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC12","String Value as 1",
                        "4713994","","","1",
                        400,-1,
                        null,
                        "Could not convert string to boolean"},

                {"TC13","String Value as 0",
                        "4713994","","","0",
                        400,-1,
                        null,
                        "Could not convert string to boolean"},

                {"TC14","Numeric Value as 0",
                        "4713994","","",0,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC15","Long Description",
                        "4714002","4235809","88433475",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC16","Claimant Mapping Validation",
                        "4713993","4235809","88433475",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC17","Docket Mapping Validation",
                        "4713993","4235809","88433475",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC18","Multiple Claimants",
                        "4714005","4235809,4235810","",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC19","Multiple Dockets",
                        "4714005","","88433475,88433476",true,
                        400,400,
                        null,
                        "Object reference not set"},

                {"TC20",generateString(1000),
                        "4714006","4235828","",true,
                        400,400,
                        null,
                        "Note Length should not exceed 200 Characters"},

                {"TC21",generateString(200),
                        "4714006","4235828","",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC22",generateString(201),
                        "4714006","4235828","",true,
                        400,400,
                        null,
                        "Note Length should not exceed 200 Characters"},

                {"TC23",generateString(200),
                        "4714005","","88433497",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC24",generateString(201),
                        "4714005","","88433497",true,
                        400,400,
                        null,
                        "Note Length should not exceed 200 Characters"},

                {"TC25","",
                        "4714006","4235828","",true,
                        400,400,
                        null,
                        "Please provide note"},

                {"TC26","",
                        "4714006","","88433497",true,
                        400,400,
                        null,
                        "Please provide note"},

                {"TC27","Added Note on 25_August_2026",
                        "4714006","4@235#828","",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC28","Added Note",
                        "4714005","","884@334#97",true,
                        400,400,
                        null,
                        "Conversion failed"},

                {"TC29","noteAdded_Updated",
                        4714006,"",88433497,true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC30","noteAdded_Updated",
                        4714006,4235828,"",true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC31","noteAdded_Updated",
                        47140060,4235828,"",true,
                        400,400,
                        null,
                        "Claim does not Exist"},

                {"TC32","noteAdded_Updated",
                        4714006,"",88433497,true,
                        200,200,
                        "Note has been added Successfully.",null},

                {"TC33","noteAdded_Updated",
                        "", "",88433497,true,
                        400,400,
                        null,
                        "Please provide CMSClaimId"},

                {"TC34","noteAdded_Updated",
                        "4714007","","88433497",true,
                        200,200,
                        "Note has been added Successfully.",null}
        };
    }

    private static String generateString(int length) {
        return "A".repeat(length);
    }
}