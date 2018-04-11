package com.lwsh.jboa.base.entity;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	
	private String id;//节点编号
	private String text;//节点名称
	private String url;//节点连接路径
	
	private List<TreeNode> treeNode = new ArrayList<TreeNode>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<TreeNode> getTreeNode() {
		return treeNode;
	}

	public void setTreeNode(List<TreeNode> treeNode) {
		this.treeNode = treeNode;
	}
	
	

}
