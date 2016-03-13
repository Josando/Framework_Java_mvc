package App.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import App.modules.main_menu.model.Config;


public class Format {

	
		public static String format1d(double number) {
			DecimalFormat format1 = new DecimalFormat(".#");
			return format1.format(number);
		}

		public static String format2d(double number) {
			DecimalFormat format1 = new DecimalFormat(".##");
			return format1.format(number);
		}

		public static String format3d(double string) {
			DecimalFormat format1 = new DecimalFormat(".###");
			return format1.format(string);
		}

		public static String FormatDollar(double moneda) {
			NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.US);// Dolar
			return coin.format(moneda);
		}

		public static String FormatLibra(double moneda) {
			NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.UK);// Libras
			return coin.format(moneda);
		}

		public static String FormatEuro(double moneda) {
			NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.FRANCE);// Euro
			return coin.format(moneda);
		}
		
		
		public static String Currency_Format(double coin ) {
			
			String money = " ";
			//float varFloat =0.0f;
			
			switch (Config.getinstance().getCurrency()) {

			case "€":// Euro
				
				NumberFormat coin1 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
				coin1.setMaximumFractionDigits(1);
				money = coin1.format(coin);
				
				//varFloat = Float.parseFloat(money);
				
				break;
				

			case "$":// Dolar
				
				NumberFormat coin2 = NumberFormat.getCurrencyInstance(Locale.US);
				coin2.setMaximumFractionDigits(2);
				money = coin2.format(coin);
				
				break;

			case "£":// Libra
				
				NumberFormat coin3 = NumberFormat.getCurrencyInstance(Locale.UK);
				coin3.setMaximumFractionDigits(3);
				money = coin3.format(coin);
				break;
			}
			
			return money;
			
			
		}
		

	}
	

