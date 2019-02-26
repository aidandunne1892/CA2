using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

/// <summary>
/// This Class is just a base class for us to use,
/// I've put everything that I think we may have in every model class we will have.
/// 
/// </summary>


namespace ApplicationBackend.Models
{
    public class SkeletonModelClass
    {
        [Required]
        public int Id { get; set; }

        public string NameOfSomething { get; set; }

        public double SomeSortOfPrice { get; set; }

        public SkeletonModelClass(int Id , string NameOfSomething, double SomeSortOfPrice)
        {
            this.Id = Id;
            this.NameOfSomething = NameOfSomething;
            this.SomeSortOfPrice = SomeSortOfPrice;
        }

        public SkeletonModelClass()
        {
            
        }


    }
}
