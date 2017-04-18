package qianlei.cn.edu.usst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Caesar {
	public static String plainText;
	public static char[] plainCh;
	public static String enText;
	public static char[] enCh;
	public static String deText;
	public static char[] deCh;
	public static String brText;
	public static String cipherText;
	public static int key;
	
	public static void main(String args[])
	{
		System.out.println("输入明文：\n");
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		plainText = null;
		try {
			plainText = buf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		plainCh=plainText.toCharArray();
		System.out.println("输入移位数：\n");
		BufferedReader buf1=new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		Pattern pattern = Pattern.compile("[0-9]*");
		try {
			str = buf1.readLine();
			if(!pattern.matcher(str).matches())
			{
				JOptionPane.showMessageDialog(null,"Please input an legle key!","Info:",JOptionPane.QUESTION_MESSAGE);
			}
			key=Integer.parseInt(str);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Please input an legle key!","Info:",JOptionPane.QUESTION_MESSAGE);
		}
		encrypt();
		enCh=enText.toCharArray();
		decrypt();
	}
	
	
	public static String encrypt(){
		for (int i = 0; i < plainCh.length; i++) {
			if(plainCh[i]>='a'&&plainCh[i]<='z')
			{
				plainCh[i]=(char) ((plainCh[i]+key-97)%26+97);
			}
			else if(plainCh[i]>='A'&&plainCh[i]<='Z')
			{
				plainCh[i]=(char) ((plainCh[i]+key-65)%26+65);
			}
		}
	    enText = String.valueOf(plainCh);
	    System.out.println("密文为："+enText);
	    return enText;	
	}
	
	public static String decrypt(){
		for (int i = 0; i < enCh.length; i++) {
			if(enCh[i]>='a'&&enCh[i]<='z')
			{
				enCh[i]=(char) ((enCh[i]+(26-key%26)-97)%26+97);
			}
			else if(enCh[i]>='A'&&enCh[i]<='Z')
			{
				enCh[i]=(char) ((enCh[i]+(26-key%26)-65)%26+65);
			}
		}
	    deText = String.valueOf(enCh);
	    System.out.println("解密为："+deText);
	    return deText;			
	}
}
