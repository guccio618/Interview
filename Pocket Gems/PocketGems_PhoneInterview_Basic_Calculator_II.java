import java.util.Stack;


public class PocketGems_PhoneInterview_Basic_Calculator_II {
	public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        char preSign = ' ';
        int ans = 0;
        int num = 0;
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + (int)(c - '0');
            } 
            
            if(!Character.isDigit(c) && c != ' ' || i == len - 1){
                if(preSign == '+'){
                    stack.push(num);
                } else if(preSign == '-'){
                    stack.push(-num);
                } else if(preSign == '*'){
                    if(!stack.isEmpty()){
                        stack.push(stack.pop() * num);
                    } else {
                        break;
                    }
                } else if(preSign == '/'){
                    if(!stack.isEmpty()){
                        stack.push(stack.pop() / num);
                    } else {
                        break;
                    }
                } else {
                    stack.push(num);
                }
                
                preSign = c;
                num = 0;
            } 
        }
        
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        
        return ans;
    }
}
