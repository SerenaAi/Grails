package org.auction

class Review {
    Account reviewerAccount
    Account revieweeAccount
    boolean reviewedSeller=false
    boolean reviewedBidder=false
    String sellerComment;
    String bidderComment;
    static constraints = {
        sellerComment(size: 0..50, nullable: true)
        bidderComment(size: 0..50, nullable: true)
    }
}
