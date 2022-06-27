package hbm.planner.utility;


import java.util.Base64;

//@SuppressWarnings("restriction")
public final class CreateData {
	
//	private static String key = "xyz";
	
	private CreateData(){
		
	}

	/********************************************************************
	 * 
	 * encryptXOR(String message, String key)
	 * 
	 * 		Uses provided key to encrypt provided message using simple XOR
	 * 
	 *********************************************************************/
	
	public static String create(String message){
				
		try {
//			if (message==null || key==null ) return null;
//		
//		    char[] keys=key.toCharArray();
//		    char[] mesg=message.toCharArray();
//		    
//		    int ml=mesg.length;
//		    int kl=keys.length;
//		    char[] newmsg=new char[ml];
//		    
//		    for (int i=0; i<ml; i++){
//		        newmsg[i]=(char)(mesg[i]^keys[i%kl]);
//		    }
//		    mesg=null; 
//		    keys=null;
//		    return new String(new BASE64Encoder().encodeBuffer(new String(newmsg).getBytes()));
			return Base64.getEncoder().encodeToString(message.getBytes("utf-8"));
		    
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
	}	
	
	
	/********************************************************************
	 * 
	 * decryptXOR(String message, String key)
	 * 
	 * 		Uses provided key to decrypt provided message encrypted using the same key
	 * 
	 *********************************************************************/
	
	public static String get(String message){		
		try {
//	      if (message==null || key==null ) return null;
//	      BASE64Decoder decoder = new BASE64Decoder();
//	      char[] keys=key.toCharArray();
//	      char[] mesg=new String(decoder.decodeBuffer(message)).toCharArray();
//
//	      int ml=mesg.length;
//	      int kl=keys.length;
//	      char[] newmsg=new char[ml];
//
//	      for (int i=0; i<ml; i++){
//	        newmsg[i]=(char)(mesg[i]^keys[i%kl]);
//	      }
//	      mesg=null; keys=null;
//	      return new String(newmsg);
			return new String(Base64.getDecoder().decode(message), "utf-8");
	    }
	    catch ( Exception e ) {
	      return null;
    }  
  }

}
