package com.worldunion.prophesy.utils.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

import org.apache.commons.lang3.StringUtils;



@SuppressWarnings("unchecked")
public class NumberUtil {
	public static Double roundHalfUp(Double d1,Double d2){
		if(d2==0){
			return 0d;
		}
		double f=(double)d1/d2*100;
		BigDecimal   b   =   new   BigDecimal(f);  
		double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
		return f1;
	}
	
	
}