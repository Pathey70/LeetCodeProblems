class BrowserHistory {

    Stack<String> forward;
    Stack<String> backward;
    String current;
    public BrowserHistory(String homepage) {
        forward=new Stack<String>();
        backward=new Stack<String>();
        //backward.push(homepage);
        current=homepage;
    }
    
    public void visit(String url) {
        backward.push(current);
        current=url;
        forward.removeAllElements();
    }
    
    public String back(int steps) {
        
        for(int i=0;i<steps;i++)
        {
            if(backward.size()==0)
            {
                break;
            }
            else
            {
                forward.push(current);
                current=backward.pop();
            }
        }
        //current=forward.peek();
        return current;
    }
    
    public String forward(int steps) {
        //backward.push(current);
        for(int i=0;i<steps;i++)
        {
            if(forward.size()==0)
            {
                break;
            }
            else
            {
                backward.push(current);
                current=forward.pop();
            }
        }
        
        return current;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */