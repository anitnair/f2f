package com.sap.f2f.data.collector.twitter;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetCollector {

	public void start() {

		   ConfigurationBuilder cb = new ConfigurationBuilder();
	        cb.setDebugEnabled(true);
	        cb.setOAuthConsumerKey("");
	        cb.setOAuthConsumerSecret("");
	        cb.setOAuthAccessToken("");
	        cb.setOAuthAccessTokenSecret("");

	        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

	        StatusListener listener = new StatusListener() {

				@Override
				public void onException(Exception arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onDeletionNotice(StatusDeletionNotice arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onScrubGeo(long arg0, long arg1) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onStallWarning(StallWarning arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onStatus(Status arg0) {
					
					System.out.println(arg0.getText());
				}

				@Override
				public void onTrackLimitationNotice(int arg0) {
					// TODO Auto-generated method stub
					
				}};
	        FilterQuery fq = new FilterQuery();
	    
	        String keywords[] = {"ireland"};

	        fq.track(keywords);

	        twitterStream.addListener(listener);
	        twitterStream.filter(fq); 

	}

	public static void main(String[] args) throws Exception {
		new TweetCollector().start();// run the Twitter client
	}
}