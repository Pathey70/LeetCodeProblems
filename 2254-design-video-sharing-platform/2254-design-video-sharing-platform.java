class VideoSharingPlatform {
    int id=0;
    PriorityQueue<Integer> pq;
    HashMap<Integer,Video> videoMapper;
    public VideoSharingPlatform() {
        pq=new PriorityQueue<>();
        videoMapper=new HashMap<>();
    }
    
    public int upload(String video) {
        int vid=id;
        if(!pq.isEmpty()){
            vid=pq.poll();
        }else{
            id++;
        }
        Video v=new Video(video);
        videoMapper.put(vid,v);
        return vid;
    }
    
    public void remove(int videoId) {
        if(videoMapper.containsKey(videoId))
        {
            videoMapper.remove(videoId);
            pq.add(videoId);
        }
    }
    
    public String watch(int videoId, int startMinute, int endMinute) {
        if(videoMapper.containsKey(videoId)){
            Video video=videoMapper.get(videoId);
            String content=video.content;
            video.views++;
            return content.substring(startMinute,Math.min(content.length(),endMinute+1));
        }
        else{
            return "-1";
        }
    }
    
    public void like(int videoId) {
        if(videoMapper.containsKey(videoId)){
            int likes[]=videoMapper.get(videoId).likes;
            likes[0]++;
        }
    }
    
    public void dislike(int videoId) {
        if(videoMapper.containsKey(videoId)){
            int likes[]=videoMapper.get(videoId).likes;
            likes[1]++;
         }
    }
    
    public int[] getLikesAndDislikes(int videoId) {
        if(videoMapper.containsKey(videoId)){
            return videoMapper.get(videoId).likes;
        }
        else{
            int def[]=new int[1];
            def[0]=-1;
            return def;
        }
    }
    public int getViews(int videoId) {
        if(videoMapper.containsKey(videoId)){
            return videoMapper.get(videoId).views;
        }
        else{
            return -1;
        }
    }
}
class Video{
    String content;
    int[] likes;
    int views;
    Video(String content){
        this.content=content;
        likes=new int[2];
        views=0;
    }
}
/**
 * Your VideoSharingPlatform object will be instantiated and called as such:
 * VideoSharingPlatform obj = new VideoSharingPlatform();
 * int param_1 = obj.upload(video);
 * obj.remove(videoId);
 * String param_3 = obj.watch(videoId,startMinute,endMinute);
 * obj.like(videoId);
 * obj.dislike(videoId);
 * int[] param_6 = obj.getLikesAndDislikes(videoId);
 * int param_7 = obj.getViews(videoId);
 */