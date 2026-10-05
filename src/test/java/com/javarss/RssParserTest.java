package com.javarss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RssParserTest {

    @Test
    void parseReturnsFeedTitleAndItems() throws Exception {
        String xml = """
            <rss version="2.0">
              <channel>
                <title>Example Feed</title>
                <link>https://example.com</link>
                <description>Example description</description>
                <item>
                  <title>First item</title>
                  <link>https://example.com/1</link>
                  <description>Hello world</description>
                  <pubDate>Mon, 01 Jan 2024 10:00:00 GMT</pubDate>
                </item>
                <item>
                  <title>Second item</title>
                  <link>https://example.com/2</link>
                  <description>Second article</description>
                  <pubDate>Tue, 02 Jan 2024 10:00:00 GMT</pubDate>
                </item>
              </channel>
            </rss>
            """;

        RssFeed feed = RssParser.parse(xml);

        assertEquals("Example Feed", feed.getTitle());
        assertEquals(2, feed.getItems().size());
        assertEquals("First item", feed.getItems().get(0).getTitle());
        assertEquals("Second item", feed.getItems().get(1).getTitle());
    }
}
