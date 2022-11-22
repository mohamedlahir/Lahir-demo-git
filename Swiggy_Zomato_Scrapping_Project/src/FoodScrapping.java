import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.opencsv.CSVWriter;

public class FoodScrapping {

	public static void main(String[] args) throws IOException {
		String swiggyfilePath = "C:\\Users\\white\\Documents\\Dinamic.io\\SwiggyScraping.csv";
		String zomatofilePath = "C:\\Users\\white\\Documents\\Dinamic.io\\ZomatoScrappingReviews.csv";

		String swiggyUrl[] =

				{ "https://www.swiggy.com/restaurants/burger-king-express-avenue-thousand-lights-chennai-11479",
						"https://www.swiggy.com/restaurants/faasos-wraps-and-rolls-purasaiwakkam-chennai-224426?sld=false",
						"https://www.swiggy.com/restaurants/buhari-buhari-purasaiwakkam-chennai-127997?sld=false",
						"https://www.swiggy.com/restaurants/oven-story-pizza-purasaiwakkam-chennai-224428?sld=false",
						"https://www.swiggy.com/restaurants/firangi-bake-purasaiwakkam-chennai-224429?sld=false",
						"https://www.swiggy.com/restaurants/pizza-hut-royapettah-thousand-lights-chennai-34335",
						"https://www.swiggy.com/restaurants/the-kati-roll-shop-guindy-chennai-543065",
						"https://www.swiggy.com/restaurants/mcdonalds-ashok-nagar-chennai-23760",
						"https://www.swiggy.com/restaurants/soy-soi-kotturpuram-chennai-78722",
						"https://www.swiggy.com/restaurants/the-summer-house-eatery-alwarpet-teynampet-chennai-55334",
						"https://www.swiggy.com/restaurants/zhouyu-alwarpet-chennai-261642",
						"https://www.swiggy.com/restaurants/the-noodle-theory-adyar-chennai-77300",
						"https://www.swiggy.com/restaurants/radio-room-mrc-nagar-raja-annamalai-puram-chennai-140524",
						"https://www.swiggy.com/restaurants/the-fat-boy-alwarpet-chennai-31049",
						"https://www.swiggy.com/restaurants/little-italy-ramapuram-chennai-33534",
						"https://www.swiggy.com/restaurants/amelies-cafe-and-creamery-near-best-hospital-dr-zaheer-ahmed-sayeed-teynampet-chennai-35056",
						"https://www.swiggy.com/restaurants/dominos-pizza-little-mount-rd-guindy-saidapet-chennai-24349",
						"https://www.swiggy.com/restaurants/bangalore-tiffin-house-kilpauk-chennai-361314",
						"https://www.swiggy.com/restaurants/sangeetha-veg-restaurant-gandhi-irwin-rd-egmore-chennai-14096",
						"https://www.swiggy.com/restaurants/dindigul-thalappakatti-n-s-c-bose-road-george-town-chennai-52548",
						"https://www.swiggy.com/restaurants/a2b-veg-purasawalkam-chennai-482248",
						"https://www.swiggy.com/restaurants/eatfit-manickam-road-aminjikarai-chennai-448584",
						"https://www.swiggy.com/restaurants/bayleaf-gopalapuram-chennai-9248",
						"https://www.swiggy.com/restaurants/the-bvk-biryani-bai-veetu-kalyanam-egmore-chennai-561677",
						"https://www.swiggy.com/restaurants/behrouz-biryani-mandaveli-lane-mandaveli-mylapore-chennai-45897",
						"https://www.swiggy.com/restaurants/meat-and-eat-aynavaram-ayanavaram-chennai-25316",
						"https://www.swiggy.com/restaurants/amadora-gourmet-ice-creams-wallace-garden-thousand-lights-chennai-12624",
						"https://www.swiggy.com/restaurants/mamagoto-nugambakkam-thousand-lights-chennai-9121",
						"https://www.swiggy.com/restaurants/subway-kilpauk-chennai-37067",
						"https://www.swiggy.com/restaurants/the-table-nungambakkam-chennai-33290",
						"https://www.swiggy.com/restaurants/chai-kings-poonamallee-high-road-egmore-chennai-18998"

				};

		String zomatoUrl[] =

				{

						"https://www.zomato.com/chennai/faasos-wraps-rolls-purasavakkam",
						"https://www.zomato.com/chennai/a2b-adyar-ananda-bhavan-purasavakkam",
						"https://www.zomato.com/chennai/soy-soi-kotturpuram",
						"https://www.zomato.com/chennai/eatfit-aminijikarai",
						"https://www.zomato.com/chennai/the-bayleaf-cathedral-road",
						"https://www.zomato.com/chennai/the-noodle-theory-kilpauk",
						"https://www.zomato.com/chennai/bangalore-tiffin-house-kilpauk",
						"https://www.zomato.com/chennai/sangeetha-veg-restaurant-1-egmore",
						"https://www.zomato.com/chennai/zhouyu-from-the-house-of-pumpkin-tales-abhiramapuram",
						"https://www.zomato.com/chennai/the-summer-house-eatery-alwarpet",
						"https://www.zomato.com/chennai/ghulams-biryani-alandur",
						"https://www.zomato.com/chennai/the-bvk-biryani-bai-veetu-kalyanam-egmore",
						"https://www.zomato.com/chennai/bikkgane-biryani-kottivakkam",
						"https://www.zomato.com/chennai/behrouz-biryani-purasavakkam",
						"https://www.zomato.com/chennai/paradise-biryani-t-nagar",
						"https://www.zomato.com/chennai/barbeque-nation-nungambakkam",
						"https://www.zomato.com/chennai/meat-and-eat-royapettah",
						"https://www.zomato.com/chennai/amelies-1-alwarpet",
						"https://www.zomato.com/chennai/pizza-hut-royapettah",
						"https://www.zomato.com/chennai/black-orchid-ra-puram",
						"https://www.zomato.com/chennai/amadora-gourmet-ice-cream-sorbet-nungambakkam",
						"https://www.zomato.com/chennai/the-noodle-theory-kilpauk",
						"https://www.zomato.com/chennai/french-loaf-egmore",
						"https://www.zomato.com/chennai/the-kati-roll-shop-gopalapuram",
						"https://www.zomato.com/chennai/mamagoto-express-avenue-royapettah",
						"https://www.zomato.com/chennai/minus-30-sholinganallur",
						"https://www.zomato.com/chennai/the-table-nungambakkam",
						"https://www.zomato.com/chennai/chai-kings-purasavakkam"

				};

		File swiggyFile = new File(swiggyfilePath);
		File zomatoFile = new File(zomatofilePath);

		FileWriter swiggyOutputfile = new FileWriter(swiggyFile);
//		FileWriter zomatoOutputfile = new FileWriter(zomatoFile);

		CSVWriter swiggyWriter = new CSVWriter(swiggyOutputfile);
		CSVWriter zomatoWriter = new CSVWriter(swiggyOutputfile);

		List<String> swiggyUrls = Arrays.asList(swiggyUrl);
		List<String> zomatoUrls = Arrays.asList(zomatoUrl);
		List<String[]> swiggyData = new ArrayList<String[]>();
		List<String[]> zomatoData = new ArrayList<String[]>();

		swiggyData.add(new String[]

		{

				"Food Item Names", "Price of the food Items", "Name of the Restaurant", "Scrapped from Swiggy/Zomato",
				"Cost for Two", "Rating of the Restaurant", "Offers", "Url of the store"

		});

		swiggyWriter.writeAll(swiggyData);

		for (int i = 0; i < swiggyUrls.size(); i++) {
			swiggyData.clear();

			Document doc = Jsoup.connect(swiggyUrls.get(i)).get();
			org.jsoup.select.Elements price = doc.select("span.rupee");
			org.jsoup.select.Elements dish = doc.select("h3.styles_itemNameText__3ZmZZ");
			org.jsoup.select.Elements storeName = doc.select("h1._3aqeL");
			org.jsoup.select.Elements components = doc.select("div._2l3H5");
			org.jsoup.select.Elements offers = doc.select("div._3F2Nk");

			Element store = storeName.first();

			int count = 0;

			String rating = components.get(0).text();
			String costOfTwoPeople[] = components.get(2).text().split(" ");
			String cost = costOfTwoPeople[1];

			for (int j = 0; j < price.size(); j++) {
				swiggyData.add(new String[] { dish.get(j).text(), price.get(j).text(), store.text(), "Swiggy", cost,
						rating, offers.text(), swiggyUrls.get(i) });
				count++;
				swiggyWriter.writeNext(swiggyData.get(j));
			}

			System.out.println(" ");
			System.out.println("Store Name : " + storeName.text());
			System.out.println("Number of Items in " + storeName.text() + " : " + count);
			System.out.println("Cost Of Two : " + cost);
			System.out.println("Rating of the Restraunts :" + rating);
			System.out.println("Delivery Time :" + "NA");
			System.out.println("Swiggy Offers : " + offers.text());

		}
		for (int k = 0; k < zomatoUrls.size(); k++) {

			zomatoData.clear();

			Document zomatoDoc = Jsoup.connect(zomatoUrls.get(k) + "/order").get();

			org.jsoup.select.Elements zomatoFoodName = zomatoDoc.select("h4.sc-1s0saks-15.iSmBPS");
			org.jsoup.select.Elements foodPrice = zomatoDoc.select("span.sc-17hyc2s-1.cCiQWA");
			org.jsoup.select.Elements zomatoRestarauntName = zomatoDoc.select("h1.sc-7kepeu-0.sc-kafWEX.kTxZkY");
			org.jsoup.select.Elements zomatoOffers1 = zomatoDoc.select("div.sc-1a03l6b-0.lkqupg");
			org.jsoup.select.Elements zomatoOffers2 = zomatoDoc.select("div.sc-1a03l6b-1.kvnZBD");
			org.jsoup.select.Elements zomatoRestrauntRating = zomatoDoc
					.select("div.sc-1q7bklc-10.jcWdhP div.sc-1q7bklc-1.cILgox");
			org.jsoup.select.Elements zomatoFoodCategories = zomatoDoc.select("h4.sc-1hp8d8a-0.sc-jMvuUo.gIPtlj");

			int zomatoCount = 0;
			for (int l = 0; l < zomatoFoodName.size(); l++) {

				String zPrice = foodPrice.get(l).text().substring(1);
				zomatoData.add(new String[] { zomatoFoodName.get(l).text(), zPrice, zomatoRestarauntName.get(0).text(),
						"Zomato", "NA", zomatoRestrauntRating.text(), zomatoOffers1.text() + zomatoOffers2.text(),
						zomatoUrls.get(k) });
				zomatoCount++;
				zomatoWriter.writeNext(zomatoData.get(l));
			}

			System.out.println(
					"*******************************************************************************************");
			System.out.println(" ");
			System.out.println("Store Name : " + zomatoRestarauntName.text());
			System.out.println("Number of Items in " + zomatoRestarauntName.text() + " : " + zomatoCount);
			System.out.println("Food Name in Zomato: " + zomatoFoodName.text());
			System.out.println("Cost Of Two : " + "NA");
			System.out.println("Rating of the Restraunts :" + "NA");
			System.out.println("Delivery Time :" + "NA");
			System.out.println("Zomato offers on " + zomatoRestarauntName.get(0).text() + " : " + zomatoOffers1.text()
					+ zomatoOffers2.text());
			if (zomatoFoodCategories.size() != 0) {
				System.out.println("Zomato Categories : " + zomatoFoodCategories.get(k).text());
			} else {
				System.out.println("Zomato Categories : NA");
			}
			System.out.println(" ");

		}
		swiggyWriter.close();

	}
}