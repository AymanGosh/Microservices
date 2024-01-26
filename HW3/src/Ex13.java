
public class Ex13 {

	public static void main(String[] args) {
		int [] arr =  {1,2,3,4,-20,-10,5,6};
		
		System.out.print(Ex13.maxMult3(arr));

	}
	
	public static int maxMult3(int [] arr) {
	
		
		if(arr.length<3) {
			return Integer.MIN_VALUE;
		}
		
		int min1,min2,max1,max2,max3;
		min1=min2=Integer.MAX_VALUE;
		max1=max2=max3=Integer.MIN_VALUE;
		
		for(int i=0; i < arr.length ; i++) {
			int number = arr[i];
			if(number > max1) {
				max3=max2;
				max2=max1;
				max1=number;
			}else if (number > max2) {
				max3=max2;
				max2=number;
			}else if(number > max3) {
				max3 = number; 
			}
			
			if(number < min1) {
				min2=min1;
				min1=number;
			}else if(number < min2) {
				min2 = number ; 
			}
		}
		int result1 = max1*max2*max3;
		int result2= max1*min1*min2; 
		
		if(result1>result2) {
			return result1;
		}else {
			return result2;
		}
		
	}

}
