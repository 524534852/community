package bristol.yhj.community.entity;

public class Page {
    //当前页数
    private int current=1;
    //一页最大数量
    private int limit=10;
    //总行数
    private int rows=0;
    //路径
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>=1)
        this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=10&&limit<=100)
        this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0)
        this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
   //得到页面开始行数
    public int getOffset()
    {
        return (current-1)*limit;
    }

    //最大页数
    public int getTotal()
    {
       return (rows%limit==0)?(rows/limit):(rows/limit+1);
    }

    //页码开始位置
    public int getFrom()
    {
        int from=current-2;
        return Math.max(from, 1);
    }
    //页码最后位置
    public int getTo()
    {
        int to=current+2;
        return Math.min(to,getTotal());
    }
}
