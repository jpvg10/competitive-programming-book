
public class KMP {
	
	private static int[] computeTemporaryArray(String pattern){
        int lps[] = new int[pattern.length()];
        int index = 0;
        int i = 1;
        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(index)){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
        
    public static int KMP(String text, String pattern){        
        int lps[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < text.length() && j < pattern.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == pattern.length()){
        	return i-j;            
        }
        return -1;
    }
    
    public static void main(String[] args) {
		String text = "ABABABABC";
		String pattern = "BABABC";
		System.out.println(KMP(text, pattern));
	}   
}
