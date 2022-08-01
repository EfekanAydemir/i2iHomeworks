use strict;
use warnings;

open(WritePrimeNumbers, ">print_PrimeNumbers.txt") or die "Cannot open file or $!";
open(ReadPrimeNumbers,"<numbers.txt") or die "Cannot open file or $!";

foreach my $line (<ReadPrimeNumbers>){
	if($line !~ 'n'){
	my $is = index($line, 'is');
	my $number = substr $line, 0,$is;
	print "$number \n";
	print WritePrimeNumbers "$number \n" ;	
	}
}


close(WritePrimeNumbers);
close(ReadPrimeNumbers);