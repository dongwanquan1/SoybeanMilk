package linkSamples;

public class LinkNode {
	private LinkNode nextNode;
	private String nodeName;
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public LinkNode(String nodeName){
		this.nodeName=nodeName;
	}
	public LinkNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(LinkNode nextNode) {
		this.nextNode = nextNode;
	}
}
