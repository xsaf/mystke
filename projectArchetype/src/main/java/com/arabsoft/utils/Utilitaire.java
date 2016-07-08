package com.arabsoft.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class Utilitaire {

	public static Date ajouterJour(Date date, int nbJour) {

		GregorianCalendar cal = new GregorianCalendar();

		cal.setTime(date);

		cal.add(Calendar.DAY_OF_MONTH, nbJour);

		return cal.getTime();
	}

	public static Long deFormaterMontantNotNull(String mnt, Long nbrDecDev, Long codDevDev) {
		if (mnt != null && nbrDecDev != null) {
			if (nbrDecDev.intValue() == 3 && codDevDev == 788L) {

				String s = mnt.replace(" ", "").replace(".", "").trim();
				return Long.valueOf(s);
			} else {

				String s = mnt.replace(" ", "").replace(".", "").trim();
				Long mntDef = Long.valueOf(s);
				mntDef = (long) (mntDef * Math.pow(10, nbrDecDev));
				return mntDef;
			}

		} else
			return 0L;

	}

	public static Long deFormaterMontant(String mnt, Long nbrDecDev, Long codDevDev) {
		if (mnt != null && nbrDecDev != null) {
			if (nbrDecDev.intValue() == 3 && codDevDev == 788L) {

				String s = mnt.replace(" ", "").replace(".", "").trim();
				return Long.valueOf(s);
			} else {

				String s = mnt.replace(" ", "").replace(".", "").trim();
				Long mntDef = Long.valueOf(s);
				mntDef = (long) (mntDef * Math.pow(10, nbrDecDev));
				return mntDef;
			}

		} else
			return null;

	}

	public static String formaterMontant(Long mnt, Long nbrDecDev, Long codDevDev) {
		if (mnt != null && nbrDecDev != null) {
			DecimalFormat df;
			Double mntD = Double.valueOf(mnt) / Math.pow(10, nbrDecDev);
			if (nbrDecDev.intValue() == 3 && codDevDev == 788L) {
				if (mnt >= 0)
					df = new DecimalFormat("# #0.000");
				else
					df = new DecimalFormat("#0.000");

				DecimalFormatSymbols dcmlFS = new DecimalFormatSymbols();
				dcmlFS.setDecimalSeparator('.');
				dcmlFS.setMinusSign('-');
				df.setDecimalFormatSymbols(dcmlFS);
				String s = df.format(mntD);
				return formatDeciaml(s);
			} else {

				return formatMnt(String.valueOf(mntD.longValue()).trim());
			}

		} else
			return null;

	}

	public static String formatDeciaml(String input) {
		boolean nnegatif = false;
		if (input != null && !input.equals("")) {
			if (input.charAt(0) == '-') {
				nnegatif = true;
				input = input.replace("-", "");
				input = input + " ";
			}
			if (input.indexOf('.') != -1) {
				int cmp = (input.length() - 1);
				Character c = input.charAt(cmp);
				while (cmp > 0 && !c.equals('.') && c.equals('0')) {
					input = input.substring(0, cmp);
					cmp--;

					c = input.charAt(cmp);
				}
				if (c.equals('.')) {
					input = input.substring(0, cmp);
				}
			}
			String dec = "";
			String vir = "";
			if (input.indexOf('.') != -1) {
				vir = "." + input.substring(input.indexOf('.') + 1);
				dec = input.substring(0, input.indexOf('.'));
				input = formatMnt(dec) + vir;
			} else {
				dec = input;
				input = formatMnt(dec);
			}

		}
		if (nnegatif) {
			input = "-" + input;
		}
		return input;
	}

	public static String getClientAdressIp() {
		HttpServletRequest request =
				((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest());
		String ip = request.getRemoteAddr();
		return ip;

	}

	public static String formatMnt(String s) {
		int rest = s.length() % 3;
		List<Character> l = new ArrayList<Character>();
		int cmps = 0;
		for (int cmp = 0; cmp < rest; cmp++) {
			l.add(s.charAt(cmp));
			cmps++;
		}
		l.add(' ');
		while (cmps < s.length() - 1) {
			for (int cmp = 0; cmp < 3; cmp++) {
				l.add(s.charAt(cmps));
				cmps++;
			}
			l.add(' ');
		}
		int cmp = 0;
		String res = "";
		while (cmp < l.size()) {
			res += l.get(cmp);
			cmp++;
		}
		return res.trim();
	}

	public static boolean existpoint(String input) {
		if (input != null) {
			Character c;
			for (int i = 0; i < input.length(); i++) {
				c = input.charAt(i);
				if (c.equals('.')) {
					return true;
				}
			}
		}
		return false;

	}

	

}
