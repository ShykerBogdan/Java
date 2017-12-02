package controller;

/**
 * Created by Gatsby on 5/22/2017.
 */
public interface Queries {
    String SELECT_BOUQUETS = "SELECT bouquets.idBouquet, bouquets.name, bouquets.accessory, flowers.FlowerName,1 flowers.flowerLength, flowers.dateAdmission, flowers.price, bouquetinfo.count \n" +
            "            FROM flowershop.bouquets\n" +
            "            INNER JOIN flowershop.bouquetinfo\n" +
            "            ON flowershop.bouquets.idBouquet = flowershop.bouquetinfo.idbouquetInfo\n" +
            "            INNER JOIN flowershop.flowers\n" +
            "            ON flowershop.flowers.idFlower = flowershop.bouquetinfo.flowerId\n" +
            "            ORDER BY bouquets.idBouquet;";
    String SELECT_FLOWERS = "SELECT * FROM flowershop.flowers";
    String INSERT_BOUQUET = "INSERT INTO `flowershop`.`bouquets` (`accessory`, `name`) VALUES ";
    String INSERT_FLOWER = "INSERT INTO `flowershop`.`flowers` (`flowerName`, `flowerLength`, `price`, `dateAdmission`) VALUES ";
    String INSERT_BOUQUET_DETAILS = "INSERT INTO `flowershop`.`bouquetInfo` (`idbouquetInfo`, `flowerId`, `count`) VALUES ";
    String SELECT_LAST_BOUQUET_INDEX = "SELECT bouquets.idBouquet FROM flowershop.bouquets WHERE bouquets.name ='";
}
