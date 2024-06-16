class Solution {
public:
    int maxBoxesInWarehouse(vector<int>& boxes, vector<int>& warehouse) {
        sort(boxes.begin(),boxes.end());
        int n=boxes.size();
        vector<int> leftEntry;
        leftEntry.push_back(warehouse[0]);
        int current=warehouse[0];
        for(int i=1;i<warehouse.size();i++)
        {
            current=min(warehouse[i],current);
            leftEntry.push_back(current);
        }
        current=warehouse[warehouse.size()-1];
        for(int i=warehouse.size()-1;i>=0;i--)
        {   
            current=min(current,warehouse[i]);
            leftEntry[i]=max(current,leftEntry[i]);
            //cout<<leftEntry[i]<<" ";
        }
        sort(leftEntry.begin(),leftEntry.end());
        int p1=0;
        int p2=0;
        //int count=0;
        while(p1<warehouse.size())
        {
            if(p2<n&&boxes[p2]<=leftEntry[p1])
            {
                p2++;
            }
            p1++;
        }
        return p2;
    }
};