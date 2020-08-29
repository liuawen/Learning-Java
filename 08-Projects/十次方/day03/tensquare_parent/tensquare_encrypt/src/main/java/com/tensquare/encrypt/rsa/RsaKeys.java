package com.tensquare.encrypt.rsa;

/**
 * rsa加解密用的公钥和私钥
 * @author Administrator
 *
 */
public class RsaKeys {

	//生成秘钥对的方法可以参考这篇帖子
	//https://www.cnblogs.com/yucy/p/8962823.html

//	//服务器公钥
//	private static final String serverPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6Dw9nwjBmDD/Ca1QnRGy"
//											 + "GjtLbF4CX2EGGS7iqwPToV2UUtTDDemq69P8E+WJ4n5W7Iln3pgK+32y19B4oT5q"
//											 + "iUwXbbEaAXPPZFmT5svPH6XxiQgsiaeZtwQjY61qDga6UH2mYGp0GbrP3i9TjPNt"
//											 + "IeSwUSaH2YZfwNgFWqj+y/0jjl8DUsN2tIFVSNpNTZNQ/VX4Dln0Z5DBPK1mSskd"
//											 + "N6uPUj9Ga/IKnwUIv+wL1VWjLNlUjcEHsUE+YE2FN03VnWDJ/VHs7UdHha4d/nUH"
//											 + "rZrJsKkauqnwJsYbijQU+a0HubwXB7BYMlKovikwNpdMS3+lBzjS5KIu6mRv1GoE"
//											 + "vQIDAQAB";
//
//	//服务器私钥(经过pkcs8格式处理)
//	private static final String serverPrvKeyPkcs8 = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDoPD2fCMGYMP8J"
//				 								 + "rVCdEbIaO0tsXgJfYQYZLuKrA9OhXZRS1MMN6arr0/wT5YniflbsiWfemAr7fbLX"
//				 								 + "0HihPmqJTBdtsRoBc89kWZPmy88fpfGJCCyJp5m3BCNjrWoOBrpQfaZganQZus/e"
//				 								 + "L1OM820h5LBRJofZhl/A2AVaqP7L/SOOXwNSw3a0gVVI2k1Nk1D9VfgOWfRnkME8"
//				 								 + "rWZKyR03q49SP0Zr8gqfBQi/7AvVVaMs2VSNwQexQT5gTYU3TdWdYMn9UeztR0eF"
//				 								 + "rh3+dQetmsmwqRq6qfAmxhuKNBT5rQe5vBcHsFgyUqi+KTA2l0xLf6UHONLkoi7q"
//				 								 + "ZG/UagS9AgMBAAECggEBANP72QvIBF8Vqld8+q7FLlu/cDN1BJlniReHsqQEFDOh"
//				 								 + "pfiN+ZZDix9FGz5WMiyqwlGbg1KuWqgBrzRMOTCGNt0oteIM3P4iZlblZZoww9nR"
//				 								 + "sc4xxeXJNQjYIC2mZ75x6bP7Xdl4ko3B9miLrqpksWNUypTopOysOc9f4FNHG326"
//				 								 + "0EMazVaXRCAIapTlcUpcwuRB1HT4N6iKL5Mzk3bzafLxfxbGCgTYiRQNeRyhXOnD"
//				 								 + "eJox64b5QkFjKn2G66B5RFZIQ+V+rOGsQElAMbW95jl0VoxUs6p5aNEe6jTgRzAT"
//				 								 + "kqM2v8As0GWi6yogQlsnR0WBn1ztggXTghQs2iDZ0YkCgYEA/LzC5Q8T15K2bM/N"
//				 								 + "K3ghIDBclB++Lw/xK1eONTXN+pBBqVQETtF3wxy6PiLV6PpJT/JIP27Q9VbtM9UF"
//				 								 + "3lepW6Z03VLqEVZo0fdVVyp8oHqv3I8Vo4JFPBDVxFiezygca/drtGMoce0wLWqu"
//				 								 + "bXlUmQlj+PTbXJMz4VTXuPl1cesCgYEA6zu5k1DsfPolcr3y7K9XpzkwBrT/L7LE"
//				 								 + "EiUGYIvgAkiIta2NDO/BIPdsq6OfkMdycAwkWFiGrJ7/VgU+hffIZwjZesr4HQuC"
//				 								 + "0APsqtUrk2yx+f33ZbrS39gcm/STDkVepeo1dsk2DMp7iCaxttYtMuqz3BNEwfRS"
//				 								 + "kIyKujP5kfcCgYEA1N2vUPm3/pNFLrR+26PcUp4o+2EY785/k7+0uMBOckFZ7GIl"
//				 								 + "FrV6J01k17zDaeyUHs+zZinRuTGzqzo6LSCsNdMnDtos5tleg6nLqRTRzuBGin/A"
//				 								 + "++xWn9aWFT+G0ne4KH9FqbLyd7IMJ9R4gR/1zseH+kFRGNGqmpi48MS61G0CgYBc"
//				 								 + "PBniwotH4cmHOSWkWohTAGBtcNDSghTRTIU4m//kxU4ddoRk+ylN5NZOYqTxXtLn"
//				 								 + "Tkt9/JAp5VoW/41peCOzCsxDkoxAzz+mkrNctKMWdjs+268Cy4Nd09475GU45khb"
//				 								 + "Y/88qV6xGz/evdVW7JniahbGByQhrMwm84R9yF1mNwKBgCIJZOFp9xV2997IY83S"
//				 								 + "habB/YSFbfZyojV+VFBRl4uc6OCpXdtSYzmsaRcMjN6Ikn7Mb9zgRHR8mPmtbVfj"
//				 								 + "B8W6V1H2KOPfn/LAM7Z0qw0MW4jimBhfhn4HY30AQ6GeImb2OqOuh3RBbeuuD+7m"
//				 								 + "LpFZC9zGggf9RK3PfqKeq30q";

	//服务器公钥
	private static final String serverPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv1Iwph37Qi0D9+uin/Dl\n" +
			"6JLEkvp0dcBFwu91YEy+BU4iOYYYSXcj2MMmzWGQGOupv6kECkJ7mKP8kCuRsB0v\n" +
			"TyVsxN5CU4Mc/0QCf6Ao53CMGTB1Rj7qH99pa375j3jTdt8PvaUvVCWT7yVqn1FV\n" +
			"OJMXMZWGC+Z70VDGdZfVVowVjPehIHyil9eazTMlosBYVNot4Pyh59QlaHdcNlBL\n" +
			"upU5aXCfVSgN/rpH0D4xPNju1JW4uN7DxUcFDlCGpoLBmM1oxU3IAdO9R2MCQBjn\n" +
			"GMaraF6SLbq+KMiuaw2nqZ4ZZSsbl8EefTvgh+KzAqdulK0LAJKFTdo/KwhPYCU5\n" +
			"xQIDAQAB";

	//服务器私钥(经过pkcs8格式处理)
	private static final String serverPrvKeyPkcs8 = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC/UjCmHftCLQP3\n" +
			"66Kf8OXoksSS+nR1wEXC73VgTL4FTiI5hhhJdyPYwybNYZAY66m/qQQKQnuYo/yQ\n" +
			"K5GwHS9PJWzE3kJTgxz/RAJ/oCjncIwZMHVGPuof32lrfvmPeNN23w+9pS9UJZPv\n" +
			"JWqfUVU4kxcxlYYL5nvRUMZ1l9VWjBWM96EgfKKX15rNMyWiwFhU2i3g/KHn1CVo\n" +
			"d1w2UEu6lTlpcJ9VKA3+ukfQPjE82O7Ulbi43sPFRwUOUIamgsGYzWjFTcgB071H\n" +
			"YwJAGOcYxqtoXpItur4oyK5rDaepnhllKxuXwR59O+CH4rMCp26UrQsAkoVN2j8r\n" +
			"CE9gJTnFAgMBAAECggEBAJb3wg+y5MtJPjJpq7/NlX26IodgPnmUKPgzgElnBSKm\n" +
			"jvcZSxzdeFnZVEsIS25+t0nXkqqN332JGQiieKmhve0UOQn34BqKAV2kStxugxht\n" +
			"hP9zb3boulJANq1uWnrN+v938LHTIM+jf2JcAhCJW1fzKYAk3suRKe73cELmdp99\n" +
			"OPjNFn4xPA9dtQPgt2LoOzYjXcr0cYp4nyyLskbFg6Zb2sUdv4f+8BHz6mcM7aOr\n" +
			"yFBLr8tQYD5iFG/YZQ+EiUaaa4pjicemtffUffM5ZjzmyT0S07HYJyOfcjYlLjEC\n" +
			"n2CSUzPB/KO3rkKfbdticlhyoAT4AiqDtOKmlDnbK5kCgYEA57pc4df92A1By/lt\n" +
			"o+acVgGeByBl7yaS0eqRCkNps1vQnVsVfYtgi9JmIg3bGoz/EqIPKswpMe9ZwqN+\n" +
			"1HQn8EVVPC0kbD4rCkmsglPjLDmqk/S2iwQpIxJNe0F2kxJ4v5Juv+qLcJ2xQFJE\n" +
			"UPjy47PXyste9guC8c/XdAKrlKsCgYEA01xXaCG3SGUXvdmI9VONczCy48NhJLdd\n" +
			"GV6UaxB5k9ijFJ7xH3uNZD/GCEzcOqIP9QcXdZBvTB8o9L9Tm3wyCwVqH+DEa8H+\n" +
			"RaLc1f/+mJ0qp5r2IUvxxoNTXFJBRSv3wbRQC+1CvvugwPgT+uEkFYWdKVv2Tw+e\n" +
			"76AaCqNtC08CgYEA5xdue3eYWfbWkCE+Gv7nF8pjGz5PCZFRR/CCFlcmOU0uHU7x\n" +
			"fpMZhDcdzYY95BuKYL2nHIof5wGIZVgBKsRv8+hg2TM3qI7TA153oD0iRz93AjhA\n" +
			"NyC+GZCuHmYpZwA71Oimc9PmnTdVxgyEvq+WIkh+wmnQWNUgECCy/6mODSMCgYAW\n" +
			"EAiLtSFFrE/LIH78ZMlaIdY6kjV8uKs+L7I8bs7SEQYM6/5tc98xfLq2ORewAyS5\n" +
			"RhE702TaxFHpImOe0lsC7YDDbRnzyZ86M6Lrr7oqwhUmw7U3io7lUuYLuAZaKxnE\n" +
			"nYbRh+W0u91u5zZmtMOof3cFTzUp0Y6cotC1FZQXXwKBgHxJFdgruz5J9vg969gC\n" +
			"xbCGAUjvKIMWlK8jvV7T0KmFBwTa1Jcvvu8XL7M1d3HRIVNT6ZqRtV4M0WeJoTO3\n" +
			"rhXMhl8IypluleSM8C3lkv522knYTUPcA7m32dTbpbJAoMzBqs/IYpO/f6uR7Vt/\n" +
			"AZFIsYQFNIZ/nvYO7mBPTeoh";

	public static String getServerPubKey() {
		return serverPubKey;
	}

	public static String getServerPrvKeyPkcs8() {
		return serverPrvKeyPkcs8;
	}
	
}
