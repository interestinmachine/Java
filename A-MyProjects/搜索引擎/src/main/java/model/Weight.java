package model;

public class Weight {

    private int docId;

    // 表示查询词和文档之间的关联性
    // weight 越大，代表关联性越强
    private int weight;

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
