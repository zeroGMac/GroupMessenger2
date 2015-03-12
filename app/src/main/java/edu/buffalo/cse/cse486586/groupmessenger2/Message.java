package edu.buffalo.cse.cse486586.groupmessenger2;

import java.util.Comparator;

/**
 * Created by rakesh on 3/11/15.
 */

public class Message implements Comparator<Message>{
    private int messageId;
    private int processId;
    private String message;
    private MessageType messageType;
    private boolean deliver;
    private int maxProp;
    private int proposedBy;
    private int repliesReceived;

    public Message() {
        this.messageId = 0;
        this.processId = 0;
        this.message = "";
        this.deliver = false;
        this.maxProp = 0;
        this.proposedBy = 0;
        this.repliesReceived = 0;
    }



    @Override
    public int compare(Message lhs, Message rhs) {
        if (lhs.getMaxProp() < rhs.getMaxProp()){
            return  -1;
        }else if(lhs.getMaxProp() > rhs.getMaxProp()){
            return 1;
        }else{
            if (lhs.getProposedBy() < rhs.getProposedBy()){
                return -1;
            }else if (lhs.getProposedBy() > rhs.getProposedBy()) {
                return 1;
            }else {
                return 0;
            }
        }
    }

    public enum MessageType {
        MSG, PROPOSAL, DECISION
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public int getMaxProp() {
        return maxProp;
    }

    public void setMaxProp(int maxProp) {
        this.maxProp = maxProp;
    }

    public boolean isDeliver() {
        return deliver;
    }

    public void setDeliver(boolean deliver) {
        this.deliver = deliver;
    }

    public int getProposedBy() {
        return proposedBy;
    }

    public void setProposedBy(int proposedBy) {
        this.proposedBy = proposedBy;
    }

    public int getRepliesReceived() {
        return repliesReceived;
    }

    public void setRepliesReceived(int repliesReceived) {
        this.repliesReceived = repliesReceived;
    }

    public Message(String serialString) {
        String [] attribs = serialString.split(";");
        this.messageId = Integer.parseInt(attribs[0]);
        this.processId = Integer.parseInt(attribs[1]) ;
        this.messageType = MessageType.valueOf(attribs[2]);
        this.message = attribs[3];
        this.deliver = false;
        this.maxProp = 0;
        this.proposedBy = 0;
        this.repliesReceived = 0;
    }

    public Message(int messageId, int processId, MessageType messageType, String message) {
        this.messageId = messageId;
        this.processId = processId;
        this.messageType = messageType;
        this.message = message;
        this.deliver = false;
        this.maxProp = 0;
        this.proposedBy = 0;
        this.repliesReceived = 0;
    }


    public String stringify(){
        String stringRep = this.messageId+";"+
                this.processId+";"+
                this.messageType.name()+";"+
                this.message;
        return stringRep;
    }

}