import java.util.ArrayList;
import java.util.List;

interface NewsChannel {
    public void update(String news);
}

class NewsAgency {
    private List<NewsChannel> channels;

    public NewsAgency() {
        channels = new ArrayList<>();
    }

    public void registerChannel(NewsChannel channel) {
        channels.add(channel);
    }

    public void unregisterChannel(NewsChannel channel) {
        channels.remove(channel);
    }

    public void broadcastNews(String news) {
        for (NewsChannel channel : channels) {
            channel.update(news);
        }
    }
}

class NewsChannel_FirstOne implements NewsChannel {
    @Override
    public void update(String news) {
        System.out.println("NewsChannel A: " + news);
    }
}

class NewsChannel_SecondOne implements NewsChannel {
    @Override
    public void update(String news) {
        System.out.println("NewsChannel B: " + news);
    }
}

class NewsChannel_ThirdOne implements NewsChannel {
    @Override
    public void update(String news) {
        System.out.println("NewsChannel C: " + news);
    }
}

public class l227971_Lab10_q1 {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        NewsChannel_FirstOne channelA = new NewsChannel_FirstOne();
        NewsChannel_SecondOne channelB = new NewsChannel_SecondOne();
        NewsChannel_ThirdOne channelC = new NewsChannel_ThirdOne();

        newsAgency.registerChannel(channelA);
        newsAgency.registerChannel(channelB);
        newsAgency.registerChannel(channelC);

        newsAgency.broadcastNews("News: Don't know what to write!");

        newsAgency.unregisterChannel(channelB);

        newsAgency.broadcastNews("Nothing Special!");
    }
}