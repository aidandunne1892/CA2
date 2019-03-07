// Console client for Stock RESTful service
// CRUD calls

using ApplicationBackend.Models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Net.Http;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Threading.Tasks;

namespace ClientSideClub
{
    class Client
    {
        private static readonly HttpClient client = new HttpClient();
        private static readonly String baseURI = "https://localhost:5001/api/Club/";

        static async Task RunGets()
        {
            try
            {
                // GET /api/Club/all
                var streamTask = client.GetStreamAsync(baseURI + "all");
                var serializer = new DataContractJsonSerializer(typeof(List<ClubModelClass>));
                var teams = serializer.ReadObject(await streamTask) as List<ClubModelClass>;
                Console.WriteLine("///////// All Clubs ///////// \n");
                foreach (var team in teams)
                {
                    Console.WriteLine("Club Details:");
                    Console.WriteLine(team.ToString());
                }


                // GET /api/Club/Liverpool
                streamTask = client.GetStreamAsync(baseURI + "Liverpool");
                serializer = new DataContractJsonSerializer(typeof(ClubModelClass));
                var club = serializer.ReadObject(await streamTask) as ClubModelClass;
                Console.WriteLine("///////// One Particular Club: ///////// \n");
                Console.WriteLine("Club Details: ");
                Console.WriteLine(club.ToString());

            }
            catch (HttpRequestException e1)
            {
                Console.WriteLine(e1.Message);
            }
            catch (Exception e2)
            {
                Console.WriteLine(e2.Message);
            }
        }


        // delete a club
        static async Task RunDelete()
        {
            try
            {
                // DELETE
                HttpResponseMessage httpResponse = await client.DeleteAsync(baseURI + "Arsenal");
                httpResponse.EnsureSuccessStatusCode();
                Console.WriteLine("Stock deleted");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }


        // kick off
        static void Main()
        {
            RunGets().Wait();
            //RunDelete().Wait();
            client.Dispose();
            Console.ReadLine();
        }
    }
}
