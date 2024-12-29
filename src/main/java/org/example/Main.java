package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();

        List<MaxProjectCountClient> maxProjectsClients = queryService.findMaxProjectsClient();
        System.out.println("Max Projects Clients: " + maxProjectsClients);

        List<LongestProject> longestProjects = queryService.findLongestProject();
        System.out.println("Longest Projects: " + longestProjects);

        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        System.out.println("Max Salary Workers: " + maxSalaryWorkers);

        List<YoungestEldestWorker> youngestEldestWorkers = queryService.findYoungestEldestWorkers();
        System.out.println("Youngest and Eldest Workers: " + youngestEldestWorkers);

        List<ProjectPrice> projectPrices = queryService.printProjectPrices();
        System.out.println("Project Prices: " + projectPrices);
    }
}
