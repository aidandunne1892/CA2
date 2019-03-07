using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using ApplicationBackend;

namespace ApplicationBackend.Models
{
    public class ClubContext : DbContext
    {
        public ClubContext(DbContextOptions<ClubContext> options)
            : base(options)
        {
        }

        public DbSet<ApplicationBackend.Models.ClubModelClass> ClubModelClass { get; set; }
    }
}
